package de.kittybot.kittybot.commands.notification;

import de.kittybot.kittybot.command.Category;
import de.kittybot.kittybot.command.application.Command;
import de.kittybot.kittybot.command.application.RunnableCommand;
import de.kittybot.kittybot.command.context.CommandContext;
import de.kittybot.kittybot.command.interaction.Options;
import de.kittybot.kittybot.command.options.CommandOptionBoolean;
import de.kittybot.kittybot.command.options.CommandOptionInteger;
import de.kittybot.kittybot.command.options.CommandOptionString;
import de.kittybot.kittybot.command.options.SubCommand;
import de.kittybot.kittybot.main.KittyBot;
import de.kittybot.kittybot.modules.NotificationModule;
import de.kittybot.kittybot.modules.PaginatorModule;
import de.kittybot.kittybot.objects.Notification;
import de.kittybot.kittybot.utils.Colors;
import de.kittybot.kittybot.utils.Config;
import de.kittybot.kittybot.utils.MusicUtils;
import de.kittybot.kittybot.utils.TimeUtils;
import net.dv8tion.jda.api.EmbedBuilder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class NotificationCommand extends Command{

	public NotificationCommand(){
		super("notification", "Creates/deletes/lists notifications", Category.NOTIFICATION);
		addOptions(

		);
	}

	public static class CreateCommand extends SubCommand{

		public CreateCommand(){
			super("create", "Creates a notification");
			addOptions(
					new CommandOptionString("time", "When to notif you. Format: `HH:mm dd.MM.yyyy` or 1y2w3d4h5m6s").required(),
					new CommandOptionString("message", "The notif message").required()/*,
					new CommandOptionBoolean("notif-in-dms", "If I should notif you in dms")*/
			);
		}

		@Override
		public void run(Options options, CommandContext ctx){
			var time = TimeUtils.parse(options.getString("time"));
			if(time == null || time.isBefore(LocalDateTime.now())){
				ctx.error("Please provide a valid time or duration in this format: ");
				return;
			}
			var message = options.getString("message");
			var notif = ctx.get(NotificationModule.class).create(
					ctx.getGuildId(),
					ctx.getChannelId(),
					-1,
					ctx.getUser().getIdLong(),
					message,
					time
			);
			if(notif == null){
				ctx.error("There was an unexpected error while creating your notification");
				return;
			}
			ctx.reply("Created Notification in `" + TimeUtils.formatDuration(notif.getCreatedAt().until(notif.getNotificationTime(), ChronoUnit.MILLIS)) + "` with id: `" + notif.getId() + "`");

		}

	}

	public static class DeleteCommand extends SubCommand{

		public DeleteCommand(){
			super("delete", "Deletes a notification");
			addOptions(
					new CommandOptionInteger("notification-id", "The notification id").required()
			);
		}

		@Override
		public void run(Options options, CommandContext ctx){
			var notificationId = options.getLong("notification-id");
			if(ctx.get(NotificationModule.class).delete(notificationId, ctx.getUserId())){
				ctx.reply("Deleted your notification with id `" + notificationId + "`");
				return;
			}
			ctx.error("Notification either does not exist or does not belong to you");
		}

	}

	public static class ListCommand extends SubCommand{

		public ListCommand(){
			super("list", "Lists your notifications");
		}

		@Override
		public void run(Options options, CommandContext ctx){
			var notifs = ctx.get(NotificationModule.class).get(ctx.getUserId());

			if(notifs.isEmpty()){
				ctx.reply("You have no notifications");
				return;
			}

			var notifMessage = new StringBuilder();
			var pages = new ArrayList<String>();

			for(var notif : notifs){
				var formattedNotif = notifMessage.append("**").append(notif.getId()).append("**").append(" scheduled for `").append(TimeUtils.format(notif.getNotificationTime())).append("`").append("\n") + "\n";
				if(notifMessage.length() + formattedNotif.length() >= 2048){
					pages.add(notifMessage.toString());
					notifMessage = new StringBuilder();
				}
				notifMessage.append(formattedNotif);
			}
			pages.add(notifMessage.toString());

			ctx.acknowledge(true);
			ctx.get(PaginatorModule.class).create(
					ctx.getChannel(),
					ctx.getUserId(),
					pages.size(),
					(page, embedBuilder) -> embedBuilder
							.setColor(Colors.KITTYBOT_BLUE)
							.setAuthor("Your Notifications", Config.ORIGIN_URL, Category.NOTIFICATION.getEmoteUrl())
							.setDescription(pages.get(page))
							.setTimestamp(Instant.now())
			);
		}

	}

}
