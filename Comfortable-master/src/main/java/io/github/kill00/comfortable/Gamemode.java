package io.github.kill00.comfortable;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.EntitySelectorArgument;
import dev.jorel.commandapi.arguments.IntegerArgument;

import dev.jorel.commandapi.arguments.MultiLiteralArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;

import static io.github.kill00.comfortable.main.c;

public class Gamemode {
    private static int GamemodeValueInt = 0;

    public static String feedback(String s, char[] GamemodeToString) {
        return String.format(Objects.requireNonNull(c().getString("commands.gamemode.success")),
                s,
                String.valueOf(GamemodeToString));
    }
    public static @NotNull Component broadcast(CommandSender sender, String s, char[] GamemodeToString) {
        return Component.text(String.format("[%s: " + c().getString("commands.gamemode.success") + "]",
                        sender.getName(),
                        s,
                        String.valueOf(GamemodeToString)))
                .decorate(TextDecoration.ITALIC)
                .color(NamedTextColor.GRAY);
    }

    public static void register() {

        new CommandAPICommand("gamemode")
                .withPermission(CommandPermission.fromString("op"))

                .withArguments(new MultiLiteralArgument("survival", "creative", "adventure", "spectator"))
                .executesPlayer((sender, args) -> {
                    var Gamemode = "";
                    switch (sender.getGameMode()) {
                        case SURVIVAL -> Gamemode = "SURVIVAL";
                        case CREATIVE -> Gamemode = "CREATIVE";
                        case ADVENTURE -> Gamemode = "ADVENTURE";
                        case SPECTATOR -> Gamemode = "SPECTATOR";
                    }
                    var value = (String)args[0];

                    if (!Objects.equals(value.toUpperCase(), Gamemode)) {
                        sender.setGameMode(GameMode.valueOf(((String) args[0]).toUpperCase()));

                        var GamemodeToString = sender.getGameMode().toString().toLowerCase().toCharArray();
                        GamemodeToString[0] = Character.toUpperCase(GamemodeToString[0]);

                        sender.sendMessage(feedback(c().getString("commands.gamemode.own"), GamemodeToString));
                        for (var p : Bukkit.getOnlinePlayers()) {
                            if (p.isOp() && !p.equals(sender)) {
                                if (Boolean.TRUE.equals(p.getWorld().getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                                    p.sendMessage(broadcast(sender, c().getString("commands.gamemode.own"), GamemodeToString));
                                }
                            }
                        }
                        if (Boolean.TRUE.equals(sender.getWorld().getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                            Bukkit.getConsoleSender().sendMessage(broadcast(sender, c().getString("commands.gamemode.own"), GamemodeToString));
                        }
                    }
                }).register();

        new CommandAPICommand("gamemode")
                .withArguments(new MultiLiteralArgument("survival", "creative", "adventure", "spectator"))
                .withArguments(new EntitySelectorArgument("target", EntitySelectorArgument.EntitySelector.MANY_PLAYERS))
                .executes((sender, args) -> {

                    @SuppressWarnings("unchecked")
                    var player = (Collection<Player>) args[1];

                    for (var loopPlayer : player) {
                        var Gamemode = "";
                        switch (loopPlayer.getGameMode()) {
                            case SURVIVAL -> Gamemode = "SURVIVAL";
                            case CREATIVE -> Gamemode = "CREATIVE";
                            case ADVENTURE -> Gamemode = "ADVENTURE";
                            case SPECTATOR -> Gamemode = "SPECTATOR";
                        }
                        var value = (String) args[0];

                        if (!Objects.equals(value.toUpperCase(), Gamemode)) {
                            loopPlayer.setGameMode(GameMode.valueOf(((String) args[0]).toUpperCase()));

                            var GamemodeToString = loopPlayer.getGameMode().toString().toLowerCase().toCharArray();
                            GamemodeToString[0] = Character.toUpperCase(GamemodeToString[0]);

                            var playerName = String.format(Objects.requireNonNull(c().getString("commands.gamemode.other")), loopPlayer.getName());

                            if (loopPlayer.getName().equals(sender.getName())) playerName = c().getString("commands.gamemode.own");

                            if (Boolean.TRUE.equals(Bukkit.getWorlds().get(0).getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                                sender.sendMessage(feedback(playerName, GamemodeToString));
                                for (var p : Bukkit.getOnlinePlayers()) {
                                    if (p.isOp() && !p.equals(sender)) {
                                        p.sendMessage(broadcast(sender, playerName, GamemodeToString));
                                    }
                                }
                                Bukkit.getConsoleSender().sendMessage(broadcast(sender, playerName, GamemodeToString));
                            }
                        }
                    }
                }).register();

        new CommandAPICommand("gamemode")
                .withArguments(new IntegerArgument("value", 0, 3))
                .executesPlayer((sender, args) -> {
                    switch (sender.getGameMode()) {
                        case SURVIVAL -> GamemodeValueInt = 0;
                        case CREATIVE -> GamemodeValueInt = 1;
                        case ADVENTURE -> GamemodeValueInt = 2;
                        case SPECTATOR -> GamemodeValueInt = 3;
                    }
                    var value = (int)args[0];

                    if (value != GamemodeValueInt) {
                        switch (value) {
                            case 0 -> sender.setGameMode(GameMode.SURVIVAL);
                            case 1 -> sender.setGameMode(GameMode.CREATIVE);
                            case 2 -> sender.setGameMode(GameMode.ADVENTURE);
                            case 3 -> sender.setGameMode(GameMode.SPECTATOR);
                        }

                        var GamemodeToString = sender.getGameMode().toString().toLowerCase().toCharArray();
                        GamemodeToString[0] = Character.toUpperCase(GamemodeToString[0]);

                        sender.sendMessage(feedback(c().getString("commands.gamemode.own"), GamemodeToString));
                        for (var p : Bukkit.getOnlinePlayers()) {
                            if (p.isOp() && !p.equals(sender)) {
                                if (Boolean.TRUE.equals(p.getWorld().getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                                    p.sendMessage(broadcast(sender, c().getString("commands.gamemode.own"), GamemodeToString));
                                }
                            }
                        }
                        if (Boolean.TRUE.equals(sender.getWorld().getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                            Bukkit.getConsoleSender().sendMessage(broadcast(sender, c().getString("commands.gamemode.own"), GamemodeToString));
                        }
                    }
                }).register();

        new CommandAPICommand("gamemode")
                .withArguments(new IntegerArgument("value", 0, 3))
                .withArguments(new EntitySelectorArgument("target", EntitySelectorArgument.EntitySelector.MANY_PLAYERS))
                .executes((sender, args) -> {
                    @SuppressWarnings("unchecked")
                    var player = (Collection<Player>) args[1];

                    for (var loopPlayer : player) {
                        switch (loopPlayer.getGameMode()) {
                            case SURVIVAL -> GamemodeValueInt = 0;
                            case CREATIVE -> GamemodeValueInt = 1;
                            case ADVENTURE -> GamemodeValueInt = 2;
                            case SPECTATOR -> GamemodeValueInt = 3;
                        }
                        var value = (int) args[0];

                        if (value != GamemodeValueInt) {
                            switch (value) {
                                case 0 -> loopPlayer.setGameMode(GameMode.SURVIVAL);
                                case 1 -> loopPlayer.setGameMode(GameMode.CREATIVE);
                                case 2 -> loopPlayer.setGameMode(GameMode.ADVENTURE);
                                case 3 -> loopPlayer.setGameMode(GameMode.SPECTATOR);
                            }

                            var GamemodeToString = loopPlayer.getGameMode().toString().toLowerCase().toCharArray();
                            GamemodeToString[0] = Character.toUpperCase(GamemodeToString[0]);

                            var playerName = String.format(Objects.requireNonNull(c().getString("commands.gamemode.other")), loopPlayer.getName());

                            if (loopPlayer.getName().equals(sender.getName()))
                                playerName = c().getString("commands.gamemode.own");

                            if (Boolean.TRUE.equals(Bukkit.getWorlds().get(0).getGameRuleValue(GameRule.SEND_COMMAND_FEEDBACK))) {
                                sender.sendMessage(feedback(playerName, GamemodeToString));
                                for (var p : Bukkit.getOnlinePlayers()) {
                                    if (p.isOp() && !p.equals(sender)) {
                                        p.sendMessage(broadcast(sender, playerName, GamemodeToString));
                                    }
                                }
                                Bukkit.getConsoleSender().sendMessage(broadcast(sender, playerName, GamemodeToString));
                            }
                        }
                    }
                }).register();
    }
}
