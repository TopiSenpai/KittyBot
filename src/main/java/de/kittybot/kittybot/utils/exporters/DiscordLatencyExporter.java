package de.kittybot.kittybot.utils.exporters;

import de.kittybot.kittybot.module.Modules;
import de.kittybot.kittybot.modules.PrometheusModule;
import io.prometheus.client.Gauge;

import java.util.concurrent.TimeUnit;

public class DiscordLatencyExporter{

	// ty Natan 👀 https://github.com/Mantaro/MantaroBot/blob/master/src/main/java/net/kodehawa/mantarobot/utils/exporters/DiscordLatencyExports.java

	private static final Gauge GATEWAY_PING = Gauge.build()
			.name("kittybot_gateway_ping")
			.help("Gateway latency in ms")
			.create();

	private static final Gauge REST_PING = Gauge.build()
			.name("kittybot_rest_ping")
			.help("Rest latency in ms")
			.create();

	public static void start(Modules modules){
		modules.getScheduler().scheduleAtFixedRate(() -> {
			var shardManager = modules.getShardManager();
			var ping = shardManager.getAverageGatewayPing();
			if(ping >= 0){
				GATEWAY_PING.set(ping);
			}
			shardManager.getShardById(0).getRestPing().queue(REST_PING::set);
		}, 0, PrometheusModule.UPDATE_PERIOD.toMillis(), TimeUnit.MILLISECONDS);
	}

	public void register(){
		GATEWAY_PING.register();
		REST_PING.register();
	}

}
