package queryys.twitchplugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import queryys.twitchplugin.commands.TwitchCommand;

public class TwitchPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("TwitchPlugin has been enabled!");

        // Get the configuration from the plugin
        FileConfiguration config = getConfig();

        // Register commands
        getCommand("twitch").setExecutor(new TwitchCommand(config));

        // Register event listeners if needed
    }

    @Override
    public void onDisable() {
        getLogger().info("TwitchPlugin has been disabled!");
    }
}
