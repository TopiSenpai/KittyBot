package de.kittybot.kittybot.commands.music;

import de.kittybot.kittybot.command.Category;
import de.kittybot.kittybot.command.application.Command;
import de.kittybot.kittybot.command.application.CommandOptionChoice;
import de.kittybot.kittybot.command.application.RunnableCommand;
import de.kittybot.kittybot.command.context.CommandContext;
import de.kittybot.kittybot.command.interaction.Options;
import de.kittybot.kittybot.command.options.CommandOptionString;
import de.kittybot.kittybot.modules.MusicModule;
import de.kittybot.kittybot.objects.SearchProvider;
import de.kittybot.kittybot.utils.MusicUtils;

@SuppressWarnings("unused")
public class ShuffleCommand extends Command implements RunnableCommand{

	public ShuffleCommand(){
		super("shuffle", "Shuffles all queued tracks", Category.MUSIC);
	}

	@Override
	public void run(Options options, CommandContext ctx){
		var player = ctx.get(MusicModule.class).get(ctx.getGuildId());
		if(!MusicUtils.checkCommandRequirements(ctx, player)){
			return;
		}
		if(ctx.get(MusicModule.class).get(ctx.getGuildId()).shuffle()){
			ctx.reply("Queue shuffled");
			return;
		}
		ctx.error("Queue is empty. Nothing to shuffle");
	}

}
