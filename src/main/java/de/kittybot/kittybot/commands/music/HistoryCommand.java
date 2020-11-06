package de.kittybot.kittybot.commands.music;

import de.kittybot.kittybot.cache.MusicManagerCache;
import de.kittybot.kittybot.objects.command.ACommand;
import de.kittybot.kittybot.objects.command.Category;
import de.kittybot.kittybot.objects.command.CommandContext;
import de.kittybot.kittybot.utils.Utils;

public class HistoryCommand extends ACommand{

	public static final String COMMAND = "history";
	public static final String USAGE = "history";
	public static final String DESCRIPTION = "Shows the current track history";
	protected static final String[] ALIASES = {"h"};
	protected static final Category CATEGORY = Category.MUSIC;

	public HistoryCommand(){
		super(COMMAND, USAGE, DESCRIPTION, ALIASES, CATEGORY);
	}

	@Override
	public void run(CommandContext ctx){
		var musicManager = MusicManagerCache.getMusicManager(ctx.getGuild());
		if(musicManager == null){
			sendError(ctx, "No active music player found");
			return;
		}
		if(ctx.getArgs().length == 0){
			var history = musicManager.getHistory();
			if(history.isEmpty()){
				sendSuccess(ctx, "There are currently no tracks in history");
				return;
			}
			var message = new StringBuilder("Currently **").append(history.size())
					.append("** ")
					.append(Utils.pluralize("track", history))
					.append(" ")
					.append(history.size() > 1 ? "are" : "is")
					.append(" in the history:\n");
			for(var track : history){
				message.append(Utils.formatTrackTitle(track)).append(" ").append(Utils.formatDuration(track.getDuration())).append("\n");
			}
			sendSuccess(ctx, message.toString());
		}
	}

}
