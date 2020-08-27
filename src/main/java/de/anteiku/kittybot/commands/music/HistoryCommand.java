package de.anteiku.kittybot.commands.music;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import de.anteiku.kittybot.objects.cache.MusicPlayerCache;
import de.anteiku.kittybot.objects.command.ACommand;
import de.anteiku.kittybot.objects.command.Category;
import de.anteiku.kittybot.objects.command.CommandContext;
import de.anteiku.kittybot.utils.Utils;

public class HistoryCommand extends ACommand {

    public static final String COMMAND = "history";
    public static final String USAGE = "history";
    public static final String DESCRIPTION = "Shows the current track history";
    protected static final String[] ALIASES = {"h"};
    protected static final Category CATEGORY = Category.MUSIC;

    public HistoryCommand() {
        super(COMMAND, USAGE, DESCRIPTION, ALIASES, CATEGORY);
    }

    @Override
    public void run(CommandContext ctx) {
        var voiceState = ctx.getMember().getVoiceState();
        if (voiceState != null && !voiceState.inVoiceChannel()) {
            sendError(ctx, "To use this command you need to be connected to a voice channel");
            return;
        }
        var musicPlayer = MusicPlayerCache.getMusicPlayer(ctx.getGuild());
        if (musicPlayer == null) {
            sendError(ctx, "No active music player found!");
            return;
        }
        if (ctx.getArgs().length == 0) {
            var history = musicPlayer.getHistory();
            if (history.isEmpty()) {
                sendAnswer(ctx, "There are currently no tracks in history");
                return;
            }
            var message = new StringBuilder("Currently ").append(history.size())
                    .append(" ")
                    .append(Utils.pluralize("track", history))
                    .append(" ")
                    .append(history.size() > 1 ? "are" : "is")
                    .append(" in the history:\n");
            for (AudioTrack track : history) {
                message.append(Utils.formatTrackTitle(track)).append(" ").append(Utils.formatDuration(track.getDuration())).append("\n");
            }
            sendAnswer(ctx, message.toString());
        }
    }

}
