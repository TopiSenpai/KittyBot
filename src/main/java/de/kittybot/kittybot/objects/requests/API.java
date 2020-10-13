package de.kittybot.kittybot.objects.requests;

import de.kittybot.kittybot.objects.Config;

public enum API{
	// stats APIs
	DISCORD_BOTS("discord.bots.gg", Config.DISCORD_BOTS_TOKEN, "https://discord.bots.gg/api/v1/bots/%s/stats", "guildCount"),
	TOP_GG("top.gg", Config.TOP_GG_TOKEN, "https://top.gg/api/bots/%s/stats", "server_count"),

	// other
	NEKOS_LIFE("nekos life", "https://nekos.life/api/v2/img/%s"),
	HASTEBIN("hastebin", Config.HASTEBIN_URL);

	private final String name;
	private final String key;
	private final String url;
	private final String statsParameter;

	API(final String name, final String key, final String url, final String statsParameter){
		this.name = name;
		this.key = key;
		this.url = url;
		this.statsParameter = statsParameter;
	}

	API(final String name, final String url){
		this.name = name;
		this.key = null;
		this.url = url;
		this.statsParameter = null;
	}

	public String getName(){
		return this.name;
	}

	public String getKey(){
		return this.key;
	}

	public String getUrl(){
		return this.url;
	}

	public String getStatsParameter(){
		return this.statsParameter;
	}
}