package com.teamvery.fchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class cmd implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            if (sender.getServer().getPlayer(args[0]) == null) {
                System.out.println(ChatColor.RED + "해당 플레이어는 존재하지 않거나 오프라인 입니다.");
            } else {
                if (args.length > 1) {
                    StringBuilder M = null;
                    for (int i = 1; i <= args.length - 1; i++) {
                        if (M == null) {
                            M = new StringBuilder(args[i]);
                        } else {
                            M.append(" ").append(args[i]);
                        }
                    }
                    Objects.requireNonNull(sender.getServer().getPlayer(args[0])).chat(M.toString());
                }
            }
            return false;
        }

        Player player = (Player) sender;
        if (label.equalsIgnoreCase("fchat"))
                if (args.length > 1) {
                    StringBuilder M = null;
                    for (int i = 1; i <= args.length - 1; i++) {
                        if (M == null) {
                            M = new StringBuilder(args[i]);
                        } else {
                            M.append(" ").append(args[i]);
                        }
                    }
                    if (player.getServer().getPlayer(args[0]) != null) {
                        Objects.requireNonNull(player.getServer().getPlayer(args[0])).chat(M.toString());
                    } else {
                        sender.sendMessage(ChatColor.RED + "해당 플레이어는 존재하지 않거나 오프라인 입니다.");
                    }
                } else {
                    sender.sendMessage("§c사용법: /fchat <닉네임> <메시지>");
                }
        return false;
    }
}