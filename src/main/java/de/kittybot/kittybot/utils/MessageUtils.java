package de.kittybot.kittybot.utils;

import de.kittybot.kittybot.objects.Emoji;

import java.time.Duration;

public class MessageUtils{

	private MessageUtils(){}

	public static String getBoolEmote(boolean bool){
		return bool ? Emoji.CHECK.getAsMention() : Emoji.X.getAsMention();
	}

	public static String maskLink(String title, String url){
		return "[" + title + "](" + url + ")";
	}

	public static String formatDurationDHMS(long length){
		return formatDurationDHMS(Duration.ofMillis(length));
	}

	public static String formatDurationDHMS(Duration duration){
		return String.format(
				"%sd %s:%s:%s", duration.toDays(), fTime(duration.toHoursPart()), fTime(duration.toMinutesPart()), fTime(duration.toSecondsPart()));
	}

	public static String fTime(int time){
		return time > 9 ? String.valueOf(time) : "0" + time;
	}

	public static String getUserMention(long userId){
		if(userId == -1L){
			return "unset";
		}
		return "<@!" + userId + ">";
	}

	public static String getRoleMention(long roleId){
		if(roleId == -1L){
			return "unset";
		}
		return "<@&" + roleId + ">";
	}

	public static String getChannelMention(long channelId){
		if(channelId == -1L){
			return "unset";
		}
		return "<#" + channelId + ">";
	}

	public static String getEmoteMention(long emoteId){
		if(emoteId == -1L){
			return "unset";
		}
		return "<:i:" + emoteId + ">";
	}

}
