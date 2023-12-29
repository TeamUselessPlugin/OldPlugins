package io.github.kill00.comfortable.ItemStack;

import de.tr7zw.nbtapi.NBTItem;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.BooleanArgument;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import dev.jorel.commandapi.arguments.IntegerArgument;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ArmorStandMeta {

    @SuppressWarnings("unchecked")
    public static void register() {

            new CommandAPICommand("ItemStack")
                    .withPermission(CommandPermission.fromString("op"))

                    // ArmorStandMeta
                    .withSubcommand(new CommandAPICommand("ArmorStandMeta")

                            // ArmorStandMeta(NoBasePlate)
                            .withSubcommand(new CommandAPICommand("NoBasePlate")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("NoBasePlate", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Invisible)
                            .withSubcommand(new CommandAPICommand("Invisible")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Invisible", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Maker)
                            .withSubcommand(new CommandAPICommand("Marker")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Marker", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Small)
                            .withSubcommand(new CommandAPICommand("Small")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Small", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(ShowArms)
                            .withSubcommand(new CommandAPICommand("ShowArms")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("ShowArms", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Glowing)
                            .withSubcommand(new CommandAPICommand("Glowing")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Glowing", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Invulnerable)
                            .withSubcommand(new CommandAPICommand("Invulnerable")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Invulnerable", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(Silent)
                            .withSubcommand(new CommandAPICommand("Silent")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("Silent", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(NoGravity)
                            .withSubcommand(new CommandAPICommand("NoGravity")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("NoGravity", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(PersistenceRequired)
                            .withSubcommand(new CommandAPICommand("PersistenceRequired")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("PersistenceRequired", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(HasVisualFire)
                            .withSubcommand(new CommandAPICommand("HasVisualFire")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("HasVisualFire", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(CustomNameVisible)
                            .withSubcommand(new CommandAPICommand("CustomNameVisible")
                                    .withArguments(new BooleanArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setBoolean("CustomNameVisible", (boolean)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(DisabledSlots)
                            .withSubcommand(new CommandAPICommand("DisabledSlots")
                                    .withArguments(new IntegerArgument("value"))
                                    .executesPlayer((sender, args) -> {
                                        var ItemStack = sender.getInventory().getItemInMainHand();

                                        if (ItemStack.getType() == Material.ARMOR_STAND) {
                                            var nbt = new NBTItem(ItemStack);

                                            var nbtEntityTags = nbt.addCompound("EntityTag");
                                            nbtEntityTags.setInteger("DisabledSlots", (int)args[0]);
                                            sender.getInventory().setItemInMainHand(nbt.getItem());
                                        } else {
                                            sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                        }
                                    }))

                            // ArmorStandMeta(CustomName)
                            .withSubcommand(new CommandAPICommand("CustomName")
                                    .withSubcommand(new CommandAPICommand("text")
                                            .withArguments(new GreedyStringArgument("content"))
                                            .executesPlayer((sender, args) -> {
                                                var ItemStack = sender.getInventory().getItemInMainHand();

                                                if (ItemStack.getType() == Material.ARMOR_STAND) {
                                                    var nbt = new NBTItem(ItemStack);

                                                    var nbtEntityTags = nbt.addCompound("EntityTag");

                                                    JSONParser jsonParser = new JSONParser();
                                                    var CustomName = new Object();
                                                    try {
                                                        CustomName = jsonParser.parse(nbtEntityTags.getString("CustomName"));
                                                    } catch (ParseException e) {
                                                        CustomName = new JSONObject();
                                                    }
                                                    JSONObject jsonObject = (JSONObject) CustomName;

                                                    jsonObject.put("text", args[0].toString().replace("&", "§"));

                                                    nbtEntityTags.setObject("CustomName", jsonObject);
                                                    sender.getInventory().setItemInMainHand(nbt.getItem());
                                                } else {
                                                    sender.playSound(sender.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.MASTER, 0.3f, 1.0f);
                                                }
                                            })))).register();
    }
}
