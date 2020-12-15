package de.kittybot.kittybot.commands.info;

import de.kittybot.kittybot.command.Category;
import de.kittybot.kittybot.command.Command;
import de.kittybot.kittybot.command.ctx.CommandContext;
import de.kittybot.kittybot.main.KittyBot;
import de.kittybot.kittybot.utils.Utils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDAInfo;

import java.lang.management.ManagementFactory;
import java.util.List;

public class InfoCommand extends Command{

	private final KittyBot main;

	public InfoCommand(KittyBot main){
		super("info", "Shows some bot info", Category.INFORMATION);
		this.main = main;
	}

	@Override
	public void run(List<String> args, CommandContext ctx){
		var jda = ctx.getJDA();
		var runtime = Runtime.getRuntime();
		ctx.sendSuccess(new EmbedBuilder()
				.setAuthor("KittyBot Information", this.main.getConfig().getString("origin_url"), jda.getSelfUser().getEffectiveAvatarUrl())

				.addField("JVM Version:", System.getProperty("java.version"), true)
				.addField("JDA Version:", JDAInfo.VERSION, true)
				.addBlankField(true)

				.addField("Total Guilds:", String.valueOf(jda.getGuildCache().size()), true)
				.addField("Total Users:", String.valueOf(Utils.getUserCount(jda)), true)
				.addBlankField(true)

				.addField("Memory Usage:", ((runtime.totalMemory() - runtime.freeMemory()) >> 20) + "MB / " + (runtime.maxMemory() >> 20) + "MB", true)
				.addField("Thread Count:", String.valueOf(ManagementFactory.getThreadMXBean().getThreadCount()), true)
		);
	}

}
