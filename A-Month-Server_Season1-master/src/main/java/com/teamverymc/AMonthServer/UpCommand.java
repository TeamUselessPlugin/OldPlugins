package com.teamverymc.AMonthServer;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class UpCommand implements CommandExecutor {
    public HashMap<Player, Long> cooldowns = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (player.getWorld() == Bukkit.getWorlds().get(0)) {
            int cooldownTime = 60;
            if(cooldowns.containsKey(player)) {

                long secondsLeft = ((cooldowns.get(player) / 1000)+cooldownTime) - (System.currentTimeMillis() / 1000);

                if(secondsLeft > 0) {
                    sender.sendMessage(secondsLeft + "초 뒤에 다시 사용할 수 있습니다.");
                    return true;
                }
            }
            cooldowns.put(player, System.currentTimeMillis());

            double x = player.getLocation().getX();
            double z = player.getLocation().getZ();
            double pitch = player.getLocation().getPitch();
            double yaw = player.getLocation().getYaw();
            int X = (int) Math.round(x);
            int Z = (int) Math.round(z);

            Location Highest = new Location(player.getWorld(), x, player.getWorld().getHighestBlockYAt(X, Z) + 1, z);
            Highest.setPitch((float) pitch);
            Highest.setYaw((float) yaw);

            player.teleport(Highest);
        } else {
            player.sendMessage(ChatColor.RED + "해당 월드에서는 '/up' 명령어를 사용할 수 없습니다.");
        }

        return false;
    }
}
