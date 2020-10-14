package de.kittybot.kittybot.commands.utilities;

import de.kittybot.kittybot.objects.Config;
import de.kittybot.kittybot.objects.command.ACommand;
import de.kittybot.kittybot.objects.command.Category;
import de.kittybot.kittybot.objects.command.CommandContext;
import de.kittybot.kittybot.objects.requests.Requester;
import de.kittybot.kittybot.utils.MessageUtils;
import net.dv8tion.jda.api.entities.Message;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HastebinCommand extends ACommand{

	public static final String COMMAND = "hastebin";
	public static final String USAGE = "hastebin <file>";
	public static final String DESCRIPTION = "creates a " + MessageUtils.maskLink("hastebin", Config.HASTEBIN_URL) + " from the file";
	protected static final String[] ALIASES = {};
	protected static final Category CATEGORY = Category.UTILITIES;

	public HastebinCommand(){
		super(COMMAND, USAGE, DESCRIPTION, ALIASES, CATEGORY);
	}

	@Override
	public void run(CommandContext ctx){
		List<Message.Attachment> attachments = ctx.getMessage().getAttachments();
		if(attachments.isEmpty()){
			sendError(ctx, "Please provide a file");
			return;
		}
		attachments.stream().filter(attachment -> !attachment.isImage() && !attachment.isVideo()).forEach(attachment -> {
			attachment.retrieveInputStream().thenAcceptAsync(inputStream -> {
				try(inputStream){
					final var text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
					sendAnswer(ctx, "[here](" + Requester.postToHastebin(text) + ") is a hastebin");
				}
				catch(final Exception e){
					LOG.error("Error while creating hastebin", e);
					sendError(ctx, "Error while creating hastebin");
				}
			});
		});
	}

}
