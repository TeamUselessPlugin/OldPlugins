package io.github.kill00.comfortable;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIConfig;
import io.github.kill00.configapi.cfg;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {
    public static FileConfiguration c() {
        return cfg.get("config.yml");
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);
        cfg.register(this);
        saveDefaultConfig();
    }

    @Override
    public void onLoad() {
        CommandAPI.onLoad(new CommandAPIConfig()
                .verboseOutput(false));

        unregister.get();

        new RegisterManager().call();
    }
}