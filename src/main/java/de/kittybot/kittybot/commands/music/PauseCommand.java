package de.kittybot.kittybot.commands.music;

import de.kittybot.kittybot.cache.MusicManagerCache;
import de.kittybot.kittybot.objects.command.ACommand;
import de.kittybot.kittybot.objects.command.Category;
import de.kittybot.kittybot.objects.command.CommandContext;

public class PauseCommand extends ACommand{

	public static final String COMMAND = "pause";
	public static final String USAGE = "pause";
	public static final String DESCRIPTION = "Pauses the current track";
	protected static final String[] ALIASES = {};
	protected static final Category CATEGORY = Category.MUSIC;

	public PauseCommand(){
		super(COMMAND, USAGE, DESCRIPTION, ALIASES, CATEGORY);
	}

	@Override
	public void run(CommandContext ctx){
		var musicManager = MusicManagerCache.getMusicManager(ctx.getGuild());
		if(musicManager == null){
			sendError(ctx, "No active music player found");
			return;
		}
		if(musicManager.getPlayingTrack() == null){
			sendError(ctx, "There is currently no song playing");
			return;
		}
		if(!musicManager.getRequesterId().equals(ctx.getUser().getId())){
			sendError(ctx, "You have to be the requester of the song to control it");
			return;
		}
		sendSuccess(ctx, "Track " + (musicManager.pause() ? "paused" : "resumed"));
	}

}
