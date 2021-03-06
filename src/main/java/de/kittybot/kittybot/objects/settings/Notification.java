package de.kittybot.kittybot.objects.settings;

import de.kittybot.kittybot.jooq.tables.records.NotificationsRecord;

import java.time.LocalDateTime;

public class Notification{

	private final long id, guildId, channelId, messageId, userId;
	private final String content;
	private final LocalDateTime notificationTime;
	private final LocalDateTime createdAt;

	public Notification(long id, long guildId, long channelId, long messageId, long userId, String content, LocalDateTime createdAt, LocalDateTime notificationTime){
		this.id = id;
		this.guildId = guildId;
		this.channelId = channelId;
		this.messageId = messageId;
		this.userId = userId;
		this.content = content;
		this.createdAt = createdAt;
		this.notificationTime = notificationTime;
	}

	public Notification(NotificationsRecord record){
		this.id = record.getId();
		this.guildId = record.getGuildId();
		this.channelId = record.getChannelId();
		this.messageId = record.getMessageId();
		this.userId = record.getUserId();
		this.content = record.getContent();
		this.createdAt = record.getCreatedAt();
		this.notificationTime = record.getNotificationTime();
	}

	public long getId(){
		return this.id;
	}

	public long getGuildId(){
		return this.guildId;
	}

	public long getChannelId(){
		return this.channelId;
	}

	public long getMessageId(){
		return this.messageId;
	}

	public long getUserId(){
		return this.userId;
	}

	public String getContent(){
		return this.content;
	}

	public LocalDateTime getCreatedAt(){
		return this.createdAt;
	}

	public LocalDateTime getNotificationTime(){
		return this.notificationTime;
	}

}
