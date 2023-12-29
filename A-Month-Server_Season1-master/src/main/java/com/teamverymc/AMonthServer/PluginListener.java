package com.teamverymc.AMonthServer;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import io.github.kill00.configapi.cfg;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

import static com.teamverymc.AMonthServer.main.config;
import static com.teamverymc.AMonthServer.main.name;

public class PluginListener implements org.bukkit.event.Listener {
    private boolean outside = false;

    private FileConfiguration c() {
        return cfg.get(config);
    }

    @EventHandler
    void DisableChat(AsyncChatEvent e) {
        if (c().getBoolean("DisableChat")) {
            e.setCancelled(true);

            e.getPlayer().sendActionBar(Component.text(ChatColor.RED + "채팅을 사용할 수 없습니다!"));
        }
    }

    @EventHandler
    void DisableSign(BlockPlaceEvent e) {
        if (c().getBoolean("DisableSign")) {
            if (e.getBlock().getState() instanceof Sign) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    void DisableJoinMessage(PlayerJoinEvent e) {
        e.joinMessage(Component.text(""));

        BossBar.get();

        if (!(e.getPlayer().hasPlayedBefore())) {
            Location randomLocation = RandomTeleport.Safe();

            e.getPlayer().teleport(randomLocation);
        }
        new Tablist().update();

    }

    @EventHandler
    void DisableQuitMessage(PlayerQuitEvent e) {
        e.quitMessage(Component.text(""));

        Bukkit.getScheduler().runTaskLater(Objects.requireNonNull(Bukkit.getPluginManager().getPlugin(name)), () -> new Tablist().update(), 0);
    }

    @EventHandler
    void DisableCommands(PlayerCommandPreprocessEvent e) {
        if (c().getBoolean("Debug")) { // 디버그용
            int count = 0;

            for (String s : c().getStringList("DebugUsers")) {

                if (!(e.getPlayer().getName().equals(s))) {
                    count++;
                }
            }

            if (count == c().getStringList("DebugUsers").size()) {
                if (!(e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().startsWith("/about") || e.getMessage().equalsIgnoreCase("/up"))) {
                    e.setCancelled(true);
                    e.getPlayer().sendActionBar(Component.text(ChatColor.RED + "명령어를 사용할 수 없습니다!"));
                }
            }

        } else {
            if (!(e.getMessage().equalsIgnoreCase("/plugins") || e.getMessage().startsWith("/about") || e.getMessage().equalsIgnoreCase("/up"))) {
                e.setCancelled(true);
                e.getPlayer().sendActionBar(Component.text(ChatColor.RED + "명령어를 사용할 수 없습니다!"));
            }
        }
    }

    @EventHandler
    void RemoveDeathMessage(PlayerDeathEvent e) {
        e.deathMessage(Component.text((ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.UNDERLINE) + "누군가 사망하였습니다..."));
    }

    @EventHandler
    void DisableBed(PlayerBedEnterEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    void DisableServerPlayerList(PaperServerListPingEvent e) {
        String size = String.valueOf((int) Bukkit.getWorlds().get(0).getWorldBorder().getSize());
        e.setNumPlayers(Integer.parseInt(size));
        e.setMaxPlayers(c().getInt("WorldBorderMaximumSize"));
        e.motd(Component.text(ChatColor.RED + "한 달 서버"));
        e.getPlayerSample().clear();
    }

    @EventHandler
    void RandomTeleport(PlayerRespawnEvent e) {
        if (e.isBedSpawn() || e.isAnchorSpawn()) {
            World world = e.getRespawnLocation().getWorld();
            WorldBorder border = world.getWorldBorder();
            if (Math.abs(e.getRespawnLocation().getX()) >= (border.getSize() / 2.0) || Math.abs(e.getRespawnLocation().getZ()) >= (border.getSize() / 2.0)) {
                Location randomLocation = RandomTeleport.Safe();
                e.setRespawnLocation(randomLocation);
            }
        } else {
            Location randomLocation = RandomTeleport.Safe();
            e.setRespawnLocation(randomLocation);
        }
    }

    @EventHandler
    void Hunger(PlayerMoveEvent e) {

        if (!(e.getPlayer().getWorld().getWorldBorder().isInside(e.getPlayer().getLocation()))) {
            if (c().getBoolean("WhenOutsideWorldBorderHunger")) {
                if (!(e.getPlayer().hasPotionEffect(PotionEffectType.HUNGER))) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 99999, 4, false, false, false));
                }
            }
            if (c().getBoolean("WhenOutsideWorldBorderPoison")) {
                if (!(e.getPlayer().hasPotionEffect(PotionEffectType.POISON))) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 99999, 0, false, false, false));
                }
            }
            outside = true;
        } else {
            if (outside) {
                e.getPlayer().removePotionEffect(PotionEffectType.POISON);
                e.getPlayer().removePotionEffect(PotionEffectType.HUNGER);
                outside = false;
            }
        }
    }
}

