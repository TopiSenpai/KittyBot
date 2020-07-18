package de.anteiku.kittybot.commands.commands;

import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.commands.ACommand;
import de.anteiku.kittybot.commands.CommandContext;

public class KissCommand extends ACommand{

	public static String COMMAND = "kiss";
	public static String USAGE = "kiss <@user, ...>";
	public static String DESCRIPTION = "Sends a kiss to a user";
	protected static String[] ALIAS = {"küss"};

	public KissCommand(KittyBot main){
		super(main, COMMAND, USAGE, DESCRIPTION, ALIAS);
	}

	@Override
	public void run(CommandContext ctx){
		if(ctx.getArgs().length == 0){
			sendUsage(ctx);
			return;
		}
		sendReactionImage(ctx, "kiss", "kisses");
	}

}
