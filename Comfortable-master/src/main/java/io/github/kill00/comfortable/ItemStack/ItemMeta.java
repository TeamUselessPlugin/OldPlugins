package io.github.kill00.comfortable.ItemStack;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.*;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.Damageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ItemMeta {
    public static void register() {
        var attributeData = new ArrayList<String>();
        var equipmentSlotData = new ArrayList<String>();
        for (var a : Attribute.values()) attributeData.add(a.toString());
        for (var e : EquipmentSlot.values()) equipmentSlotData.add(e.toString());

        new CommandAPICommand("ItemStack")
                .withPermission(CommandPermission.fromString("op"))

                // ItemStack(nbtClear)
                .withSubcommand(new CommandAPICommand("nbtClear")
                        .executesPlayer((sender, args) -> {
                            var ItemStack = sender.getInventory().getItemInMainHand();
                            var meta = new org.bukkit.inventory.ItemStack(Material.ARMOR_STAND).getItemMeta();

                            ItemStack.setItemMeta(meta);
                        }))

                // ItemMeta
                .withSubcommand(new CommandAPICommand("ItemMeta")

                        // ItemMeta(Name)
                        .withSubcommand(new CommandAPICommand("displayName")
                                .withArguments(new GreedyStringArgument("value"))
                                .executesPlayer((sender, args) -> {
                                    var ItemStack = sender.getInventory().getItemInMainHand();
                                    var meta = ItemStack.getItemMeta();
                                    var name = (String) args[0];
                                    name = name.replace("&", "§");

                                    if (!name.equalsIgnoreCase("__reset__")) {
                                        meta.displayName(Component.text(name));
                                    } else meta.displayName(null);
                                    ItemStack.setItemMeta(meta);
                                }))

                        // ItemStack(lore)
                        .withSubcommand(new CommandAPICommand("lore")

                                // lore(add)
                                .withSubcommand(new CommandAPICommand("add")
                                        .withArguments(new GreedyStringArgument("value"))
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();
                                            var name = (String) args[0];
                                            name = name.replace("&", "§");

                                            List<Component> list;
                                            try {
                                                list = new ArrayList<>(Objects.requireNonNull(meta.lore()));
                                            } catch (NullPointerException e) {
                                                list = new ArrayList<>();
                                            }
                                            list.add(Component.text(name));
                                            meta.lore(list);
                                            ItemStack.setItemMeta(meta);
                                        }))

                                // lore(set)
                                .withSubcommand(new CommandAPICommand("set")
                                        .withArguments(new IntegerArgument("Line"))
                                        .withArguments(new GreedyStringArgument("value"))
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();
                                            var name = (String) args[1];
                                            name = name.replace("&", "§");

                                            List<Component> list;
                                            try {
                                                list = new ArrayList<>(Objects.requireNonNull(meta.lore()));
                                            } catch (NullPointerException e) {
                                                list = new ArrayList<>();
                                            }
                                            list.set((int) args[0], Component.text(name));
                                            meta.lore(list);
                                            ItemStack.setItemMeta(meta);
                                        }))

                                // lore(remove)
                                .withSubcommand(new CommandAPICommand("remove")
                                        .withArguments(new IntegerArgument("Line"))
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();

                                            List<Component> list;
                                            try {
                                                list = new ArrayList<>(Objects.requireNonNull(meta.lore()));
                                            } catch (NullPointerException e) {
                                                return;
                                            }
                                            list.remove((int) args[0]);
                                            meta.lore(list);
                                            ItemStack.setItemMeta(meta);
                                        }))

                                // lore(reset)
                                .withSubcommand(new CommandAPICommand("reset")
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();

                                            meta.lore(null);
                                            ItemStack.setItemMeta(meta);
                                        })))

                        // ItemMeta(damage)
                        .withSubcommand(new CommandAPICommand("damage")
                                .withArguments(new IntegerArgument("value", 0))
                                .executesPlayer((sender, args) -> {
                                    var ItemStack = sender.getInventory().getItemInMainHand();
                                    var meta = ItemStack.getItemMeta();

                                    if (meta instanceof Damageable damage) {
                                        damage.setDamage((int) args[0]);
                                    }
                                    ItemStack.setItemMeta(meta);
                                }))

                        // ItemMeta(amount)
                        .withSubcommand(new CommandAPICommand("amount")
                                .withArguments(new IntegerArgument("value", 0, 64))
                                .executesPlayer((sender, args) -> {
                                    var ItemStack = sender.getInventory().getItemInMainHand();
                                    ItemStack.setAmount((int) args[0]);
                                }))

                        // ItemMeta(unbreakable)
                        .withSubcommand(new CommandAPICommand("unbreakable")
                                .withArguments(new BooleanArgument("value"))
                                .executesPlayer((sender, args) -> {
                                    var ItemStack = sender.getInventory().getItemInMainHand();
                                    var meta = ItemStack.getItemMeta();

                                    meta.setUnbreakable((boolean) args[0]);
                                    ItemStack.setItemMeta(meta);
                                }))
                        // ItemMeta(AttributeModifiers)
                        .withSubcommand(new CommandAPICommand("attribute")

                                // attribute(add)
                                .withSubcommand(new CommandAPICommand("add")
                                        .withArguments(new MultiLiteralArgument(attributeData.toArray(new String[0])))
                                        .withArguments(new MultiLiteralArgument(equipmentSlotData.toArray(new String[0])))
                                        .withArguments(new DoubleArgument("amount"))
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();

                                            meta.addAttributeModifier(Attribute.valueOf((String) args[0]),
                                                    new AttributeModifier(UUID.randomUUID(),
                                                            "AttributeModifier",
                                                            (double) args[2],
                                                            AttributeModifier.Operation.ADD_NUMBER,
                                                            EquipmentSlot.valueOf((String) args[1])));
                                            ItemStack.setItemMeta(meta);
                                        }))

                                // attribute(remove)
                                .withSubcommand(new CommandAPICommand("remove")
                                        .withArguments(new MultiLiteralArgument(attributeData.toArray(new String[0])))
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();

                                            meta.removeAttributeModifier(Attribute.valueOf((String) args[0]));
                                            ItemStack.setItemMeta(meta);
                                        }))

                                // attribute(reset)
                                .withSubcommand(new CommandAPICommand("reset")
                                        .executesPlayer((sender, args) -> {
                                            var ItemStack = sender.getInventory().getItemInMainHand();
                                            var meta = ItemStack.getItemMeta();

                                            for (var a : Attribute.values()) meta.removeAttributeModifier(a);
                                        })))).register();
    }
}
