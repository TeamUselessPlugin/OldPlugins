package com.teamvery.kits;

import com.teamvery.kits.cmd.newkits;
import com.teamvery.kits.cmd.oldkits;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("기본템")).setExecutor(new newkits());
        Objects.requireNonNull(getCommand("기본템old")).setExecutor(new oldkits());

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        config.setup(); config.save();
    }
}
