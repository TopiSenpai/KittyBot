package de.kittybot.kittybot.commands.info;

import de.kittybot.kittybot.cache.ReactiveMessageCache;
import de.kittybot.kittybot.objects.Config;
import de.kittybot.kittybot.objects.Emojis;
import de.kittybot.kittybot.objects.command.ACommand;
import de.kittybot.kittybot.objects.command.Category;
import de.kittybot.kittybot.objects.command.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

import static de.kittybot.kittybot.utils.MessageUtils.maskLink;

public class HelpCommand extends ACommand{

	public static final String COMMAND = "help";
	public static final String USAGE = "help";
	public static final String DESCRIPTION = "Shows some help stuff";
	protected static final String[] ALIASES = {"?"};
	protected static final Category CATEGORY = Category.INFORMATIVE;

	public HelpCommand(){
		super(COMMAND, USAGE, DESCRIPTION, ALIASES, CATEGORY);
	}

	@Override
	public void run(CommandContext ctx){
		answer(ctx, new EmbedBuilder().setColor(Color.orange)
				.setThumbnail(ctx.getJDA().getSelfUser().getEffectiveAvatarUrl())
				.addField(Emojis.INVITE + " Invite", Emojis.BLANK + " :small_blue_diamond: Do you want me on your server? Click " + maskLink("here", Config.INVITE_URL) + " to invite me!", false)
				.addField(":gear: Settings", Emojis.BLANK + " :small_blue_diamond: You can manage all your settings in our " + maskLink("dashboard", Config.ORIGIN_URL + "/guilds") + "!", false)
				.addField(Emojis.CONSOLE + " Commands", Emojis.BLANK + " :small_blue_diamond: I heard you'd like to see **all my available commands**?\n" + Emojis.BLANK + " " + Emojis.BLANK +
						" Use ``.commands``", false)
				.addField(":question: Help", Emojis.BLANK + " :small_blue_diamond: We'd be happy if you could **report bugs or suggest new features**!\n" + Emojis.BLANK + " " + Emojis.BLANK +
						" Join my " + maskLink("support server", "https://discord.gg/sD3ABd5") + ", " + maskLink("create an issue", "https://github.com/KittyBot-Org/KittyBot/issues/new") +
						" on my " + Emojis.GITHUB + " " + maskLink("GitHub repository", "https://github.com/KittyBot-Org/KittyBot") + " or message my owner on " + Emojis.TWITTER + " " +
						maskLink("Twitter", "https://twitter.com/TopiSenpai") + " or " + Emojis.DISCORD + " " + maskLink("Discord - toπ#3141", "https://discord.com/users/170939974227591168") + "!", false)
		).queue(message -> {
			ReactiveMessageCache.addReactiveMessage(ctx, message, this, ctx.getUser().getId());
			message.addReaction(Emojis.WASTEBASKET).queue();
		});
	}

}
