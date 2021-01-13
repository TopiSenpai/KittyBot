package de.kittybot.kittybot.commands.admin;

import de.kittybot.kittybot.command.Args;
import de.kittybot.kittybot.command.Category;
import de.kittybot.kittybot.command.Command;
import de.kittybot.kittybot.command.context.CommandContext;
import de.kittybot.kittybot.modules.SettingsModule;
import de.kittybot.kittybot.utils.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;

import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class UnignoreCommand extends Command{

	public UnignoreCommand(){
		super("unignore", "Makes Kitty unignore users", Category.ADMIN);
		setUsage("<@User/user_id ...>");
		addPermissions(Permission.ADMINISTRATOR);
	}

	@Override
	protected void run(Args args, CommandContext ctx){
		var users = ctx.getMentionedUsers();
		for(var arg : args.getList()){
			if(!Utils.isSnowflake(arg)){
				continue;
			}
			try{
				var user = ctx.getJDA().retrieveUserById(arg).complete();
				if(!users.contains(user)){
					users.add(user);
				}
			}
			catch(ErrorResponseException ignored){}
		}
		if(users.isEmpty()){
			ctx.sendError("Please provide a user");
		}
		ctx.get(SettingsModule.class).deleteBotIgnoredUsers(ctx.getGuildId(), users.stream().map(User::getIdLong).collect(Collectors.toSet()));
		ctx.sendSuccess(new EmbedBuilder().setDescription("Unignoring following users: " + users.stream().map(User::getAsMention).collect(Collectors.joining(", "))));
	}

}
