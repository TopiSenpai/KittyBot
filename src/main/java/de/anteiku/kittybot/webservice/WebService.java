package de.anteiku.kittybot.webservice;

import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.objects.ValuePair;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static spark.Spark.*;

public class WebService{
	
	private final KittyBot main;

	public WebService(KittyBot main, int port){
		this.main = main;
		port(port);
		
		path("/user", () -> {
			before("", this::checkDiscordLogin);
			path("/me", () -> get("/guilds/get", this::getGuilds));
		});
		path("/guild", () -> {
			before("", this::checkDiscordLogin);
			path("/:guildId", () -> {
				before("", this::checkGuildPerms);
				path("/commandprefix", () -> {
					get("/get", this::getCommandPrefix);
					get("/set/:value", this::setCommandPrefix);
					get("/set/", this::setCommandPrefix);
				});
				path("/roles", () -> get("/get", this::getAllRoles));
				path("/icon", () -> get("/get", this::getIcon));
				path("/channels", () -> get("/get", this::getAllChannels));
				path("/selfassignableroles", () -> {
					get("/get", this::getSelfAssignableRoles);
					get("/add/:value", this::addSelfAssignableRole);
					get("/remove/:value", this::removeSelfAssignableRole);
				});
				path("/welcomechannel", () -> {
					get("/get", this::getWelcomeChannel);
					get("/set/:value", this::setWelcomeChannel);
				});
				path("/nsfw", () -> {
					get("/get", this::getNSFWEnabled);
					get("/set/:value", this::setNSFWEnabled);
				});
				path("/welcomemessage", () -> {
					get("/get", this::getWelcomeMessage);
					get("/set/:value", this::setWelcomeMessage);
					get("/enabled/set/:value", this::setWelcomeMessageEnabled);
					get("/enabled/get", this::getWelcomeMessageEnabled);
				});
			});
		});
	}
	
	private void checkDiscordLogin(Request request, Response response){
		if(!loggedIn(request)){
			halt(401, "<a href='/login'>Please login with discord!</a>");
		}
	}
	
	private void checkGuildPerms(Request request, Response response){
		String guildId = request.params(":guildId");
		Guild guild = main.jda.getGuildById(guildId);
		if(guild == null){
			halt(401, "<a href='/login'>Please login with discord!</a>");
		}
		else{
			Member member = guild.getMemberById(main.database.getSession(request.cookie("key")));
			if(member == null){
				halt(401, "<a href='/login'>Please login with discord!</a>");
			}
			else{
				if(!member.hasPermission(Permission.ADMINISTRATOR)){
					halt(401, "<a href='/login'>Please login with discord!</a>");
				}
			}
		}
	}
	
	public boolean loggedIn(Request request){
		String key = request.cookie("key");
		if(key == null){
			return false;
		}
		else{
			return main.database.sessionExists(key);
		}
	}
	
	private String getIcon(Request request, Response response){
		//System.out.println("getIcon());
		return main.jda.getGuildById(request.params(":guildId")).getIconUrl();
	}
	
	private String getGuilds(Request request, Response response){
		StringBuilder json = new StringBuilder("{\"guilds\": [");
		User user = main.jda.getUserById(main.database.getSession(request.cookie("key")));
		for(Guild guild : main.jda.getMutualGuilds(user)){
			if(guild.getMember(user).hasPermission(Permission.ADMINISTRATOR)){
				json.append("{\"name\": \"").append(guild.getName()).append("\", \"id\": \"").append(guild.getId()).append("\", \"iconurl\": \"").append(guild.getIconUrl()).append("\"}, ");
			}
		}
		json.append("]}");
		if(json.lastIndexOf(",") != -1){
			json.deleteCharAt(json.lastIndexOf(","));
		}
		return json.toString();
	}
	
	private String getAllChannels(Request request, Response response){
		List<TextChannel> channels = main.jda.getGuildById(request.params(":guildId")).getTextChannels();
		StringBuilder json = new StringBuilder("{\"channels\": [");
		for(TextChannel c : channels){
			json.append("{\"name\": \"").append(c.getName()).append("\", \"id\": \"").append(c.getId()).append("\"}, ");
		}
		json.append("]}");
		if(json.lastIndexOf(",") != -1){
			json.deleteCharAt(json.lastIndexOf(","));
		}
		//System.out.println("getAllChannels(): '" + json.toString() + "'");
		return json.toString();
	}
	
	private String getAllRoles(Request request, Response response){
		List<Role> roles = main.jda.getGuildById(request.params(":guildId")).getRoles();
		StringBuilder json = new StringBuilder("{\"roles\": [");
		for(Role r : roles){
			json.append("{\"name\": \"").append(r.getName()).append("\", \"id\": \"").append(r.getId()).append("\"}, ");
		}
		json.append("]}");
		if(json.lastIndexOf(",") != -1){
			json.deleteCharAt(json.lastIndexOf(","));
		}
		//System.out.println("getAllRoles(): '" + json.toString() + "'");
		return json.toString();
	}
	
	private String getSelfAssignableRoles(Request request, Response response){
		Set<ValuePair<String, String>> roles = main.database.getSelfAssignableRoles(request.params(":guildId"));
		Guild guild = main.jda.getGuildById(request.params(":guildId"));
		StringBuilder json = new StringBuilder("{\"selfassignableroles\": [");
		if(!roles.isEmpty()){
			for(ValuePair<String, String> role : roles){
				json.append("{\"name\": \"").append(guild.getRoleById(role.getKey()).getName()).append("\", \"id\": \"").append(role.getKey()).append("\", \"emote: \n").append(guild.getEmoteById(role.getValue()).getImageUrl()).append("\"},");
			}
		}
		json.append("]}");
		if(json.lastIndexOf(",") != -1){
			json.deleteCharAt(json.lastIndexOf(","));
		}
		return json.toString();
	}
	
	private String removeSelfAssignableRole(Request request, Response response){
		main.database.removeSelfAssignableRole(request.params(":guildId"), request.params(":value"));
		return "{\"status\": \"ok\" }";
	}
	
	private String addSelfAssignableRole(Request request, Response response){
		main.database.addSelfAssignableRole(request.params(":guildId"), request.params(":value"), request.params(":emote"));
		return "{\"status\": \"ok\"}";
	}
	
	private String getWelcomeChannel(Request request, Response response){
		StringBuilder json = new StringBuilder("{");
		String channelId = main.database.getWelcomeChannelId(request.params(":guildId"));
		json.append("\"welcomechannel\": \"").append(channelId).append("\"").append("}");
		return json.toString();
	}
	
	private String setWelcomeChannel(Request request, Response response){
		main.database.setWelcomeChannelId(request.params(":guildId"), request.params(":value"));
		return "{\"status\": \"ok\"}";
	}
	
	private String getWelcomeMessage(Request request, Response response){
/*		StringBuilder json = new StringBuilder("{");
		json.append("\"welcomemessage\": \"").append(main.database.getWelcomeMessage(request.params(":guildId"))).append("\"");
		json.append("}");
		//System.out.println("getWelcomeMessage(): '" + json.toString() + "'"); */
		return main.database.getWelcomeMessage(request.params(":guildId"));
	}
	
	private String setWelcomeMessage(Request request, Response response){
		main.database.setWelcomeMessage(request.params(":guildId"), request.params(":value").trim());
		//System.out.println("setWelcomeMessage()");
		return "{\"status\": \"ok\"}";
	}
	
	private String getWelcomeMessageEnabled(Request request, Response response){
		//System.out.println("getWelcomeMessageEnabled(): '" + main.database.getWelcomeMessageEnabled(request.params(":guildId")) + "'");
		return "{\"welcomemessageenabled\": " + main.database.getWelcomeMessageEnabled(request.params(":guildId")) + "}";
	}
	
	private String setWelcomeMessageEnabled(Request request, Response response){
		main.database.setWelcomeMessageEnabled(request.params(":guildId"), Boolean.parseBoolean(request.params(":value")));
		//System.out.println("setWelcomeMessageEnabled()");
		return "{\"status\": \"ok\"}";
	}
	
	private String getNSFWEnabled(Request request, Response response){
		//System.out.println("getNSFWEnabled(): '" + main.database.getNSFWEnabled(request.params(":guildId")) + "'");
		return "{\"nsfwenabled\": " + main.database.getNSFWEnabled(request.params(":guildId")) + "}";
	}
	
	private String setNSFWEnabled(Request request, Response response){
		main.database.setNSFWEnabled(request.params(":guildId"), Boolean.parseBoolean(request.params(":value")));
		//System.out.println("setNSFWEnabled()");
		return "{\"status\": \"ok\"}";
	}
	
	private String getCommandPrefix(Request request, Response response){
		//System.out.println("getCommandPrefix(): '" + json.toString() + "'");
		return "{\"commandprefix\": \"" + main.database.getCommandPrefix(request.params(":guildId")) + "\"}";
	}
	
	private String setCommandPrefix(Request request, Response response){
		if(request.params(":value") == null){
			main.database.setCommandPrefix(request.params(":guildId"), ".");
		}
		else{
			main.database.setCommandPrefix(request.params(":guildId"), request.params(":value"));
		}
		//System.out.println("setCommandPrefix()");
		return "{\"status\": \"ok\"}";
	}
	
	public static class HtmlObject{
		
		private String body;
		private final Map<String, String > map;
		
		public HtmlObject(String body, Map<String, String> map){
			this.body = body;
			this.map = map;
		}
		
		public HtmlObject(String body){
			this.body = body;
			this.map = new LinkedHashMap<>();
		}
		
		public String getBody(){
			for(Map.Entry<String, String> e : map.entrySet()){
				if(e.getKey() != null && e.getValue() != null){
					body = body.replaceAll(e.getKey(), e.getValue());
				}
			}
			return body;
		}
		
		public void addRegex(String regex, String value){
			regex = regex.toLowerCase();
			map.put(":" + regex + ":", value);
		}
		
	}
	
	private static class HtmlTemplateEngine extends TemplateEngine{
		
		@Override
		public String render(ModelAndView modelAndView){
			return ((HtmlObject)modelAndView.getModel()).getBody();
		}
		
	}
	
}
