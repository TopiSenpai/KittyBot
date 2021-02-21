package de.kittybot.kittybot.commands.info.info;

import de.kittybot.kittybot.slashcommands.application.CommandOptionChoice;
import de.kittybot.kittybot.slashcommands.application.options.CommandOptionInteger;
import de.kittybot.kittybot.slashcommands.application.options.CommandOptionUser;
import de.kittybot.kittybot.slashcommands.application.options.SubCommand;
import de.kittybot.kittybot.slashcommands.interaction.Interaction;
import de.kittybot.kittybot.slashcommands.interaction.Options;
import de.kittybot.kittybot.utils.Colors;
import de.kittybot.kittybot.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;

@SuppressWarnings("unused")
public class AvatarCommand extends SubCommand{

	public AvatarCommand(){
		super("avatar", "Gets the avatar of a user");
		addOptions(
			new CommandOptionUser("user", "The user to get the avatar from"),
			new CommandOptionInteger("size", "The image size")
				.addChoices(
					new CommandOptionChoice<>("16px", 16),
					new CommandOptionChoice<>("32px", 32),
					new CommandOptionChoice<>("64px", 64),
					new CommandOptionChoice<>("128px", 128),
					new CommandOptionChoice<>("256px", 256),
					new CommandOptionChoice<>("512px", 512),
					new CommandOptionChoice<>("1024px", 1024),
					new CommandOptionChoice<>("2048px", 2048)
				)
		);
	}

	@Override
	public void run(Options options, Interaction ia){
		var user = options.has("user") ? options.getUser("user") : ia.getUser();
		var size = options.has("size") ? options.getInt("size") : 1024;

		ia.reply(new EmbedBuilder()
			.setColor(Colors.KITTYBOT_BLUE)
			.setTitle(user.getAsTag() + " Avatar")
			.setThumbnail(user.getEffectiveAvatarUrl())
			.setDescription(MessageUtils.maskLink(size + "px", user.getEffectiveAvatarUrl() + "?size=" + size))
		);
	}

}
