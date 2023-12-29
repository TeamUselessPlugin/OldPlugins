package io.github.kill00.comfortable;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.EntityTypeArgument;
import dev.jorel.commandapi.arguments.LocationArgument;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class Summon {

    public static void register() {
        new CommandAPICommand("summon-beta")
                .withPermission(CommandPermission.fromString("op"))

                .withArguments(new EntityTypeArgument("entity"))
                .withArguments(new LocationArgument("location"))
                .executesPlayer((sender, args) -> {
                    sender.getWorld().spawnEntity((Location)args[1], (EntityType)args[0]);
                    sender.sendMessage("소환됨");
                }).register();
    }
}
