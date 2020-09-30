package de.kittybot.kittybot.objects.cache;

import de.kittybot.kittybot.KittyBot;
import de.kittybot.kittybot.objects.MusicPlayer;
import net.dv8tion.jda.api.entities.Guild;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MusicPlayerCache{

	private static final Map<String, MusicPlayer> MUSIC_PLAYERS = new ConcurrentHashMap<>();

	public static void addMusicPlayer(Guild guild, MusicPlayer player){
		MUSIC_PLAYERS.put(guild.getId(), player);
	}

	public static void pruneCache(Guild guild){ // just a convenience method to match other pruneCache methods
		destroyMusicPlayer(guild);
	}

	public static void destroyMusicPlayer(Guild guild){
		var musicPlayer = getMusicPlayer(guild);
		if(musicPlayer == null){
			return;
		}
		KittyBot.getLavalink().getLink(guild).destroy();
		ReactiveMessageCache.removeReactiveMessage(guild, musicPlayer.getMessageId());
		MUSIC_PLAYERS.remove(guild.getId());
	}

	public static MusicPlayer getMusicPlayer(Guild guild){
		return MUSIC_PLAYERS.get(guild.getId());
	}

}