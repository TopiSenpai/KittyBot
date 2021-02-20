package de.kittybot.kittybot.commands.info.info;

import de.kittybot.kittybot.slashcommands.application.CommandOptionChoice;
import de.kittybot.kittybot.slashcommands.application.options.CommandOptionInteger;
import de.kittybot.kittybot.slashcommands.application.options.CommandOptionLong;
import de.kittybot.kittybot.slashcommands.application.options.SubCommand;
import de.kittybot.kittybot.slashcommands.interaction.GuildInteraction;
import de.kittybot.kittybot.slashcommands.interaction.Interaction;
import de.kittybot.kittybot.slashcommands.interaction.Options;
import de.kittybot.kittybot.utils.Colors;
import de.kittybot.kittybot.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;

@SuppressWarnings("unused")
public class GuildBannerCommand extends SubCommand{

	public GuildBannerCommand(){
		super("guildbanner", "Gets the guild banner");
		addOptions(
			new CommandOptionLong("guild-id", "The guild id to get the banner from"),
			new CommandOptionInteger("size", "The image size")
				.addChoices(
					new CommandOptionChoice<>("16", 16),
					new CommandOptionChoice<>("32", 32),
					new CommandOptionChoice<>("64", 64),
					new CommandOptionChoice<>("128", 128),
					new CommandOptionChoice<>("256", 256),
					new CommandOptionChoice<>("512", 512),
					new CommandOptionChoice<>("1024", 1024),
					new CommandOptionChoice<>("2048", 2048)
				)
		);
	}

	@Override
	public void run(Options options, Interaction ia){
		var guildId = options.getOrDefault("guild-id", ia instanceof GuildInteraction ? ((GuildInteraction) ia).getGuildId() : -1L);
		if(guildId == -1L){
			ia.error("Please provide a guild id");
			return;
		}
		var size = options.has("size") ? options.getInt("size") : 1024;

		var guild = ia.getJDA().getGuildById(guildId);
		if(guild == null){
			ia.error("Guild not found in my cache");
			return;
		}
		var banner = guild.getBannerUrl();
		if(banner == null){
			ia.error("Guild has no banner set");
			return;
		}
		ia.reply(new EmbedBuilder()
			.setColor(Colors.KITTYBOT_BLUE)
			.setTitle(guild.getName() + " Banner")
			.setThumbnail(banner)
			.setDescription(MessageUtils.maskLink(size + "px", banner + "?size=" + size)));
	}

}
