package queryys.twitchplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import queryys.twitchplugin.util.MessageUtil;

public class TwitchCommand implements CommandExecutor {

    private final FileConfiguration config;

    public TwitchCommand(FileConfiguration config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("twitch")) {
            if (args.length == 1) {
                String twitchUsername = args[0];
                String twitchNotification = config.getString("messages.twitchNotification");
                if (twitchNotification != null) {
                    // Replace {twitchUsername} with the actual Twitch username
                    twitchNotification = twitchNotification.replace("{twitchUsername}", twitchUsername);
                    MessageUtil.broadcastMessage(twitchNotification);
                } else {
                    sender.sendMessage("Twitch notification message is not configured in the plugin.");
                }
                return true;
            } else {
                sender.sendMessage("Usage: /twitch <TwitchUsername>");
                return false;
            }
        }
        return false;
    }
}
