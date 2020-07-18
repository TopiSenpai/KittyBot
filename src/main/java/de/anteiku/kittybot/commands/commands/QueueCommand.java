package de.anteiku.kittybot.commands.commands;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import de.anteiku.kittybot.KittyBot;
import de.anteiku.kittybot.commands.ACommand;
import de.anteiku.kittybot.commands.CommandContext;
import de.anteiku.kittybot.utils.Utils;

public class QueueCommand extends ACommand{

	public static String COMMAND = "queue";
	public static String USAGE = "queue <playlist/song/video>";
	public static String DESCRIPTION = "Queues what you want him to play later";
	protected static String[] ALIAS = {"q"};

	public QueueCommand(KittyBot main){
		super(main, COMMAND, USAGE, DESCRIPTION, ALIAS);
		this.main = main;
	}

	@Override
	public void run(CommandContext ctx){
		var voiceState = ctx.getMember().getVoiceState();
		if(!voiceState.inVoiceChannel()){
			sendError(ctx, "To use this command you need to be connected to a voice channel");
			return;
		}
		var musicPlayer = KittyBot.commandManager.getMusicPlayer(ctx.getGuild());
		if(musicPlayer == null){
			sendError(ctx, "No active music player found!");
			return;
		}
		if(ctx.getArgs().length == 0){
			var queue = musicPlayer.getQueue();
			if(queue.isEmpty()){
				sendAnswer(ctx, "There are currently no tracks queued");
				return;
			}
			StringBuilder message = new StringBuilder("Currently ").append(queue.size()).append(" tracks are queued:\n");
			for(AudioTrack track : queue){
				message.append(Utils.formatTrackTitle(track)).append(" ").append(Utils.formatDuration(track.getDuration())).append("\n");
			}
			sendAnswer(ctx, message.toString());
			return;
		}
		musicPlayer.loadItem(this, ctx, ctx.getArgs());
		//TODO maybe create one if no one is created yet?
	}

}
