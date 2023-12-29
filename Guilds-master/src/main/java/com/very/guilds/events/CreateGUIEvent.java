package com.very.guilds.events;

import com.very.guilds.Guilds;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CreateGUIEvent implements Listener {

    Guilds plugin;

    public CreateGUIEvent(Guilds plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void ClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        //GUI이름 확인
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "길드")){
            if (e.getCurrentItem() == null) {
                //TODO add execute
            } else if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                e.setCancelled(true);
            } else if (e.getCurrentItem().getType() == Material.BARRIER) {
                e.setCancelled(true);
                player.closeInventory();
            }
        }
    }
}