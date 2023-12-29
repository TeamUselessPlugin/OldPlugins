package com.teamverymc.AMonthServer;

import io.github.kill00.configapi.cfg;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.teamverymc.AMonthServer.main.*;

public class PluginCommand implements CommandExecutor, TabExecutor {

    public void help(CommandSender sender) {
        sender.sendMessage("/ams setup - 세팅");
        sender.sendMessage("/ams start - 시작");
        sender.sendMessage("/ams stop - 중지");
        sender.sendMessage("/ams reload - 리로드");
    }
    
    private FileConfiguration c() {
        return cfg.get(config);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("help")) {
                help(sender);
            } else if (args[0].equalsIgnoreCase("start")) {
                for (World w : Bukkit.getWorlds()) {
                    w.setSpawnLocation(0, w.getHighestBlockYAt(0, 0), 0);
                    w.getWorldBorder().setCenter(c().getInt("WorldBorderCenter.X"), c().getInt("WorldBorderCenter.Y"));
                    w.getWorldBorder().setSize(c().getInt("WorldBorderMinimumSize"), c().getInt("WorldBorderTime"));
                }

                sender.sendMessage("시작되었습니다!");
            } else if (args[0].equalsIgnoreCase("stop")) {
                for (World w : Bukkit.getWorlds()) {
                    w.setSpawnLocation(0, w.getHighestBlockYAt(0, 0), 0);
                    w.getWorldBorder().setCenter(c().getInt("WorldBorderCenter.X"), c().getInt("WorldBorderCenter.Y"));
                    w.getWorldBorder().setSize(c().getInt("WorldBorderMaximumSize"));
                }
                sender.sendMessage("중지되었습니다!");
            } else if (args[0].equalsIgnoreCase("reload")) {
                for (World w : Bukkit.getWorlds()) {
                    w.setGameRule(GameRule.KEEP_INVENTORY, c().getBoolean("InventorySave"));
                    w.setGameRule(GameRule.REDUCED_DEBUG_INFO, c().getBoolean("DisableF3"));
                    w.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, c().getBoolean("EnableAnnounceAdvancement"));
                    w.setGameRule(GameRule.DO_INSOMNIA, c().getBoolean("doInsomnia"));
                }

                sender.sendMessage(ChatColor.GREEN + "리로드 완료!");
            } else if (args[0].equalsIgnoreCase("setup")) {
                for (World w : Bukkit.getWorlds()) {
                    w.setSpawnLocation(0, w.getHighestBlockYAt(0, 0), 0);
                    w.getWorldBorder().setCenter(c().getInt("WorldBorderCenter.X"), c().getInt("WorldBorderCenter.Y"));
                    w.getWorldBorder().setSize(c().getInt("WorldBorderMaximumSize"));
                    w.getWorldBorder().setWarningDistance(c().getInt("WorldBorderWarningDistance"));
                    w.getWorldBorder().setDamageAmount(c().getDouble("WorldBorderDamage"));

                    w.setGameRule(GameRule.SPAWN_RADIUS, 0);
                    w.setGameRule(GameRule.KEEP_INVENTORY, c().getBoolean("InventorySave"));
                    w.setGameRule(GameRule.REDUCED_DEBUG_INFO, c().getBoolean("DisableF3"));
                    w.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, c().getBoolean("EnableAnnounceAdvancement"));
                    w.setGameRule(GameRule.DO_INSOMNIA, c().getBoolean("doInsomnia"));

                }
                sender.sendMessage("설정완료!");
            } else {
                help(sender);
            }
        } else {
            help(sender);
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, String[] args) {
        if (args.length == 1) {
            List<String> arguments = new ArrayList<>();
            List<String> matches;
            arguments.add("help");
            arguments.add("setup");
            arguments.add("start");
            arguments.add("stop");
            arguments.add("reload");
            matches = arguments.stream().filter(val -> val.toLowerCase().startsWith(args[0].toLowerCase())).collect(Collectors.toList());

            return matches;
        }

        return null;
    }
}
