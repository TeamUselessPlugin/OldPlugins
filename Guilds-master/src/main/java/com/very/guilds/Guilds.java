package com.very.guilds;

import com.very.guilds.cmd.main;
import com.very.guilds.events.CreateGUIEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Guilds extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("길드")).setExecutor(new main(this));
        getServer().getPluginManager().registerEvents(new CreateGUIEvent(this), this);
        System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　\n" +
                "　　　■■■■■■■　　　　　　　　　　■■■　■■■■　　　　■■■■　　\n" +
                "　　■■■■　■■■　　　　　　　　　　■■■　　■■■　　　　　■■■　　\n" +
                "　　■■■　　　■■■　　　　　　　　　　　　　　■■■　　　　　■■■　　\n" +
                "　■■■　　　　　　　■■■　■■■　　■■■　　■■■　　■■■■■■　　\n" +
                "　■■■　　　　　　　■■■　■■■　　■■■　　■■■　■■■■■■■　　\n" +
                "　■■■　　■■■■■■■■　■■■　　■■■　　■■■　■■■　■■■　　\n" +
                "　■■■　　　■■■　■■■　■■■　　■■■　　■■■　■■■　■■■　　\n" +
                "　■■■■　　■■■　■■■　■■■　　■■■　　■■■　■■■　■■■　　\n" +
                "　　■■■■　■■■　■■■　■■■　　■■■　■■■■■■■■■■■■　　\n" +
                "　　　■■■■■■■　　■■■■■■■■■■■■　　　　　　■■■■■■■　\n" +
                "　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　");

    }

    public void openGuildMenu(Player player){

        //길드 GUI 오픈
        Inventory guildgui = Bukkit.createInventory(player, 9, ChatColor.BLUE + "길드");
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancel_meta = cancel.getItemMeta();
        cancel_meta.setDisplayName(ChatColor.RED + "나가기");
        cancel.setItemMeta(cancel_meta);

        ItemStack clear = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta clear_meta = cancel.getItemMeta();
        clear_meta.setDisplayName("§c ");
        clear.setItemMeta(clear_meta);

        guildgui.setItem(0, clear);
        guildgui.setItem(1, clear);
        guildgui.setItem(2, clear);
        guildgui.setItem(3, clear);
        guildgui.setItem(4, clear);
        guildgui.setItem(5, clear);
        guildgui.setItem(6, clear);
        guildgui.setItem(7, clear);
        guildgui.setItem(8, cancel);

        player.openInventory(guildgui);
        }
}