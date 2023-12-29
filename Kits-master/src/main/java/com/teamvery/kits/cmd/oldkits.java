package com.teamvery.kits.cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class oldkits implements CommandExecutor {

    private void get(Player player) {
        //철검
        ItemStack ISA = new ItemStack(Material.IRON_SWORD);
        ItemMeta IS = ISA.getItemMeta();
        IS.setDisplayName("§b§n§l기본 칼");
        ISA.setItemMeta(IS);
        ISA.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        ISA.addEnchantment(Enchantment.DURABILITY, 3);
        player.getInventory().addItem(ISA);
        //곡괭이
        ItemStack ISB = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta IS1 = ISB.getItemMeta();
        IS1.setDisplayName("§b§n§l기본 곡괭이");
        ISB.setItemMeta(IS1);
        ISB.addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 2);
        ISB.addEnchantment(Enchantment.DURABILITY, 3);
        ISB.addEnchantment(Enchantment.DIG_SPEED, 3);
        player.getInventory().addItem(ISB);
        //도끼
        ItemStack ISC = new ItemStack(Material.IRON_AXE);
        ItemMeta IS2 = ISC.getItemMeta();
        IS2.setDisplayName("§b§n§l기본 도끼");
        ISC.setItemMeta(IS2);
        ISC.addEnchantment(Enchantment.DURABILITY, 3);
        ISC.addEnchantment(Enchantment.DIG_SPEED, 3);
        player.getInventory().addItem(ISC);
        //삽
        ItemStack ISD = new ItemStack(Material.IRON_SHOVEL);
        ItemMeta IS3 = ISD.getItemMeta();
        IS3.setDisplayName("§b§n§l기본 삽");
        ISD.setItemMeta(IS3);
        ISD.addEnchantment(Enchantment.DURABILITY, 3);
        ISD.addEnchantment(Enchantment.DIG_SPEED, 2);
        player.getInventory().addItem(ISD);
        //스테이크
        ItemStack ISE = new ItemStack(Material.COOKED_BEEF, 64);
        ItemMeta IS4 = ISE.getItemMeta();
        ISE.setItemMeta(IS4);
        player.getInventory().addItem(ISE);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (!(sender instanceof Player)) {
            System.out.println("§c버킷에서는 사용할수 없습니다!");
            return false;
        }

        Player player = (Player) sender;

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("inf")) {
                if (player.hasPermission("kits.teamvery.getinf.old")) {
                    get(player);
                    player.sendMessage("지급 완료");
                } else {
                    player.sendMessage("§c당신은 권한이 없어 해당 명령어를 요청할수 없습니다.");
                }
            }
        }
        return false;
    }
}
