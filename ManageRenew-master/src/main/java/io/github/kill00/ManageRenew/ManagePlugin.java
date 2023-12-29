package io.github.kill00.ManageRenew;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import io.github.kill00.configapi.cfg;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class ManagePlugin extends JavaPlugin {

    public static FileConfiguration c() {
        return cfg.get("config.yml");
    }

    @Override
    public void onEnable() {
        cfg.register(this);
        cfg.makeData("config.yml");
        getServer().getPluginManager().registerEvents(new ManageListener(), this);

        CommandAPI.onLoad(new CommandAPIConfig().verboseOutput(true));

        ManageCommand.register();
    }
}