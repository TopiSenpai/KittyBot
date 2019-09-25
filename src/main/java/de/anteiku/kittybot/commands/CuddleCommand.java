package de.anteiku.kittybot.commands;

import de.anteiku.kittybot.KittyBot;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CuddleCommand extends Command{
	
	public static String COMMAND = "cuddle";
	public static String USAGE = "cuddle <@user>";
	public static String DESCRIPTION = "Cuddles a user";
	public static String[] ALIAS = {"knuddel"};
	
	public CuddleCommand(KittyBot main){
		super(main, COMMAND, USAGE, DESCRIPTION, ALIAS);
	}
	
	@Override
	public void run(String[] args, GuildMessageReceivedEvent event){
		if(args.length != 1){
			sendUsage(event.getMessage());
			return;
		}
		sendReactionImage(event, "hug", "hugs");
	}
	
}
