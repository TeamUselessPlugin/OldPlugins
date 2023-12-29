package io.github.kill00.comfortable;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.BooleanArgument;
import dev.jorel.commandapi.arguments.EnchantmentArgument;
import dev.jorel.commandapi.arguments.IntegerArgument;
import org.bukkit.enchantments.Enchantment;

public class Enchant {

    public static void register() {
        new CommandAPICommand("enchant")
                .withPermission(CommandPermission.fromString("op"))

                .withSubcommand(new CommandAPICommand("add")
                        .withArguments(new EnchantmentArgument("Enchant"))
                        .withArguments(new IntegerArgument("Level", 1))
                        .executesPlayer((sender, args) -> {
                            var MainHand = sender.getInventory().getItemInMainHand();
                            var meta = MainHand.getItemMeta();

                            meta.addEnchant((Enchantment) args[0], (int) args[1], true);
                            MainHand.setItemMeta(meta);
                        })
                )

                .withSubcommand(new CommandAPICommand("addAll")
                        .withArguments(new IntegerArgument("Level", 1))
                        .withArguments(new BooleanArgument("withoutCurse"))
                        .executesPlayer((sender, args) -> {
                            var MainHand = sender.getInventory().getItemInMainHand();
                            var meta = MainHand.getItemMeta();

                            if ((boolean)args[1]) {
                                for (var e : Enchantment.values()) {
                                    if (!(e.equals(Enchantment.BINDING_CURSE) || e.equals(Enchantment.VANISHING_CURSE))) {
                                        meta.addEnchant(e, (int) args[0], true);
                                        MainHand.setItemMeta(meta);
                                    }
                                }
                            } else {
                                for (var e : Enchantment.values()) {
                                    meta.addEnchant(e, (int) args[0], true);
                                    MainHand.setItemMeta(meta);
                                }
                            }
                        })
                )

                .withSubcommand(new CommandAPICommand("addAll")
                        .withArguments(new IntegerArgument("Level", 1))
                        .executesPlayer((sender, args) -> {
                            var MainHand = sender.getInventory().getItemInMainHand();
                            var meta = MainHand.getItemMeta();

                            for (var e : Enchantment.values()) {
                                meta.addEnchant(e, (int) args[0], true);
                                MainHand.setItemMeta(meta);
                            }
                        })
                )

                .withSubcommand(new CommandAPICommand("remove")
                        .withArguments(new EnchantmentArgument("Enchant"))
                        .executesPlayer((sender, args) -> {
                            sender.getInventory().getItemInMainHand().removeEnchantment((Enchantment) args[0]);
                        })
                )

                .withSubcommand(new CommandAPICommand("removeAll")
                        .executesPlayer((sender, args) -> {
                            for (var e : Enchantment.values()) {
                                sender.getInventory().getItemInMainHand().removeEnchantment(e);
                            }
                        })
                ).register();
    }
}
