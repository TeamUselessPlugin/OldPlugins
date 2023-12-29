package com.teamverymc.AMonthServer;

import io.github.kill00.configapi.cfg;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static com.teamverymc.AMonthServer.main.config;

public record BossBar(main plugin) {
    private static org.bukkit.boss.BossBar bossbar;

    private static FileConfiguration c() {
        return cfg.get(config);
    }

    public static void createBar() {
        String size = String.valueOf((int) Bukkit.getWorlds().get(0).getWorldBorder().getSize());

        bossbar = Bukkit.createBossBar(
                "월드보더 크기 : " + size + "/" + c().getInt("WorldBorderMaximumSize")
                , BarColor.BLUE
                , BarStyle.SOLID
        );
        bossbar.setProgress(1.0);
        bossbar.setVisible(false);
    }

    public static void get() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            bossbar.addPlayer(player);
            bossbar.setVisible(true);
        }
    }

    public static void update() {
        String size = String.valueOf((int) Bukkit.getWorlds().get(0).getWorldBorder().getSize());
        double progress;
        if (c().getBoolean("BossbarProgress")) {
            progress = (Bukkit.getWorlds().get(0).getWorldBorder().getSize() - c().getInt("WorldBorderMinimumSize")) / (c().getInt("WorldBorderMaximumSize") - c().getInt("WorldBorderMinimumSize"));
        } else {
            progress = 1.0;
        }

        try {
            bossbar.setTitle("월드보더 크기 : " + size + "/" + c().getInt("WorldBorderMaximumSize"));
            bossbar.removeAll();
            for (Player player : Bukkit.getOnlinePlayers()) {
                bossbar.addPlayer(player);
                bossbar.setProgress(progress);
                bossbar.setVisible(true);
            }
        } catch (IllegalArgumentException e) { return; }

    }

    public static void stop() {
        bossbar.removeAll();
    }
}
