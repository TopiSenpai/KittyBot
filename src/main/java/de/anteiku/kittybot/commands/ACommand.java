package de.anteiku.kittybot.commands;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.utils.Emotes;
import de.anteiku.kittybot.utils.Logger;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import okhttp3.Request;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class ACommand{
	
	protected KittyBot main;
	protected String command;
	protected String usage;
	protected String description;
	protected String[] alias;
	
	protected Message sendAnswer(Message message, String answer){
		addStatus(message, Status.OK);
		return sendAnswer(message.getTextChannel(), answer);
	}
	
	protected ACommand(KittyBot main, String command, String usage, String description, String[] alias){
		this.main = main;
		this.command = command;
		this.usage = usage;
		this.description = description;
		this.alias = alias;
	}
	
	protected void addStatus(Message message, Status status){
		Emotes emote;
		switch(status){
			case OK:
				emote = Emotes.CHECK;
				break;
			case ERROR:
				emote = Emotes.X;
				break;
			case QUESTION:
			default:
				emote = Emotes.QUESTION;
				break;
		}
		message.addReaction(emote.get()).queue();
		message.getTextChannel().removeReactionById(message.getId(), emote.get()).queueAfter(5, TimeUnit.SECONDS);
	}
	
	public abstract void run(String[] args, GuildMessageReceivedEvent event);
	
	public boolean checkCmd(String cmd){
		if(cmd.equalsIgnoreCase(command)){
			return true;
		}
		for(String a : alias){
			if(a.equalsIgnoreCase(cmd)){
				return true;
			}
		}
		return false;
	}
	
	public String[] getAlias(){
		return alias;
	}
	
	public String getCommand(){
		return command;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getUsage(){
		return usage;
	}
	
	public void reactionAdd(Message command, GuildMessageReactionAddEvent event){
		if(event.getReactionEmote().getName().equals(Emotes.WASTEBASKET.get())){
			event.getChannel().deleteMessageById(event.getMessageId()).queue();
			command.delete().queue();
		}
		else if(event.getReactionEmote().getName().equals(Emotes.QUESTION.get())){
			event.getReaction().removeReaction(event.getUser()).queue();
			sendUsage(event.getChannel());
		}
	}
	
	protected enum Status{
		OK, ERROR, QUESTION
	}
	
	protected Message sendPrivate(Message message, MessageEmbed eb){
		return message.getAuthor().openPrivateChannel().complete().sendMessage(eb).complete();
	}
	
	protected Message sendPrivate(Message message, String msg){
		return message.getAuthor().openPrivateChannel().complete().sendMessage(new EmbedBuilder().setDescription(msg).build()).complete();
	}
	
	protected Message sendAnswer(Message message, String answer, String title){
		addStatus(message, Status.OK);
		return sendAnswer(message.getTextChannel(), answer, title);
	}
	
	protected Message sendAnswer(TextChannel channel, String answer){
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.GREEN);
		eb.setDescription(answer);
		return sendAnswer(channel, eb.build());
	}
	
	protected Message sendAnswer(Message message, MessageEmbed answer){
		addStatus(message, Status.OK);
		return sendAnswer(message.getTextChannel(), answer);
	}
	
	protected Message sendAnswer(TextChannel channel, String answer, String title){
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.GREEN);
		eb.setTitle(title);
		eb.setDescription(answer);
		return sendAnswer(channel, eb.build());
	}
	
	public Message sendError(Message message, String error){
		addStatus(message, Status.ERROR);
		return sendError(message.getTextChannel(), error);
	}
	
	protected Message sendAnswer(TextChannel channel, MessageEmbed answer){
		return channel.sendMessage(answer).complete();
	}
	
	protected Message sendUsage(Message message, String usage){
		addStatus(message, Status.QUESTION);
		return sendUsage(message.getTextChannel(), usage);
	}
	
	protected Message sendError(TextChannel channel, String error){
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.RED);
		eb.addField("Error:", error, true);
		
		return channel.sendMessage(eb.build()).complete();
	}
	
	protected Message sendUsage(Message message){
		return sendUsage(message.getTextChannel(), usage);
	}
	
	protected Message sendUsage(TextChannel channel){
		return sendUsage(channel, usage);
	}
	
	protected Message sendUsage(TextChannel channel, String usage){
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(Color.ORANGE);
		eb.addField("Command usage:", "`" + main.database.getCommandPrefix(channel.getGuild().getId()) + usage + "`", true);
		
		return channel.sendMessage(eb.build()).complete();
	}
	
	protected Message sendReactionImage(GuildMessageReceivedEvent event, String type, String text){
		List<User> users = event.getMessage().getMentionedUsers();
		if(users.isEmpty() || users.contains(event.getAuthor())){
			return sendError(event.getMessage(), "You need to mention a User(or not yourself :p)");
		}
		else{
			StringBuilder mentioned = new StringBuilder();
			for(User user : users){
				mentioned.append(user.getAsMention()).append(", ");
			}
			if(mentioned.lastIndexOf(",") != - 1){
				mentioned.deleteCharAt(mentioned.lastIndexOf(","));
			}
			String url = getNeko(type);
			if(url == null){
				return sendError(event.getMessage(), "Unknown error occurred while getting image for `" + type + "`");
			}
			return sendAnswer(event.getMessage(), new EmbedBuilder().setDescription(event.getAuthor().getAsMention() + " " + text + " " + mentioned).setImage(url).build());
		}
	}
	
	protected Message sendImage(TextChannel channel, String url){
		return sendAnswer(channel, new EmbedBuilder().setImage(url).setColor(Color.GREEN).build());
	}
	
	protected Message sendImage(Message message, String url){
		return sendAnswer(message, new EmbedBuilder().setImage(url).setColor(Color.GREEN).build());
	}
	
	protected String getNeko(String type){
		try{
			Request request = new Request.Builder().url("https://nekos.life/api/v2/img/" + type).build();
			JsonParser jp = new JsonParser();
			return jp.parse(main.httpClient.newCall(request).execute().body().string()).getAsJsonObject().get("url").getAsString();
		}
		catch(IOException e){
			Logger.error(e);
		}
		return null;
	}
	
	protected Message sendUnsplashImage(Message message, String search){
		try{
			Request request = new Request.Builder().url("https://unsplash.com/photos/random/?client_id=" + main.unsplashClientId + "&query=" + search).build();
			JsonParser jp = new JsonParser();
			String url = jp.parse(main.httpClient.newCall(request).execute().body().string()).getAsJsonObject().get("urls").getAsJsonObject().get("regular").getAsString();
			return sendImage(message.getTextChannel(), url);
		}
		catch(JsonIOException | JsonSyntaxException | IOException e){
			Logger.error(e);
		}
		return null;
	}
	
	protected Message sendLocalImage(Message message, String image){
		try{
			Request request = new Request.Builder().url("http://anteiku.de:9000/" + image).build();
			String url = main.httpClient.newCall(request).execute().body().string();
			return sendImage(message.getTextChannel(), url);
		}
		catch(IOException e){
			Logger.error(e);
		}
		return null;
	}
	
}