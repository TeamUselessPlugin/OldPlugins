package com.teamverymc.AMonthServer;

import io.github.kill00.configapi.cfg;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public final class main extends JavaPlugin {

    public static String name = "A-Month-Server";
    public static String config = "config.yml";

    @Override
    public void onEnable() {

        cfg.register(this);
        cfg.makeData(config);

        getLogger().info("-----");
        getLogger().info("프로젝트: '한 달 서버' 시작!");
        getLogger().info("-----");

        Objects.requireNonNull(getCommand("ams")).setExecutor(new PluginCommand());
        Objects.requireNonNull(getCommand("up")).setExecutor(new UpCommand());
        getServer().getPluginManager().registerEvents(new PluginListener(), this);

        RecipeRemove.useless_remove();

        BossBar.createBar();

        new BukkitRunnable() {

            @Override
            public void run() {
                BossBar.update();

            }
        }.runTaskTimer(this, 10L * 2L, 10L * 2L);
    }

    @Override
    public void onDisable() {
        BossBar.stop();
    }
}