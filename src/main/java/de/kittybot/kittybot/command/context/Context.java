package de.kittybot.kittybot.command.context;

import de.kittybot.kittybot.module.Module;
import de.kittybot.kittybot.module.Modules;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

public class Context{

	protected final Modules modules;
	protected final Guild guild;
	protected final TextChannel channel;

	protected Context(Modules modules, Guild guild, TextChannel channel){
		this.modules = modules;
		this.guild = guild;
		this.channel = channel;
	}

	public JDA getJDA(){
		return this.modules.getJDA(this.guild.getIdLong());
	}

	public Modules getModules(){
		return this.modules;
	}

	public <T extends Module> T get(Class<T> clazz){
		return this.modules.get(clazz);
	}

	public Guild getGuild(){
		return this.guild;
	}

	public long getGuildId(){
		return this.guild.getIdLong();
	}

	public TextChannel getChannel(){
		return this.channel;
	}

	public long getChannelId(){
		return this.channel.getIdLong();
	}

}
