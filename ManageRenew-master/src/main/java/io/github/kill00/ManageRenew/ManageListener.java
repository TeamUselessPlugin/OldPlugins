package io.github.kill00.ManageRenew;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

import static io.github.kill00.ManageRenew.ManagePlugin.c;
import static net.kyori.adventure.text.Component.text;

public class ManageListener implements Listener {

    @EventHandler
    void OnJoin(PlayerJoinEvent event) {
        if (!c().getBoolean("JoinMessage")) event.joinMessage(text(""));
    }

    @EventHandler
    void OnQuit(PlayerQuitEvent event) {
        if (!c().getBoolean("QuitMessage")) event.quitMessage(text(""));
    }

    @EventHandler
    void OnChat(AsyncChatEvent event) {
        if (!event.getPlayer().hasPermission("manage.chat")) event.setCancelled(!c().getBoolean("Chat"));
    }

    @EventHandler
    void OnCommand(PlayerCommandPreprocessEvent event) {
        if (!event.getPlayer().hasPermission("manage.command")) event.setCancelled(!c().getBoolean("Command"));
    }

    @EventHandler
    void OnHunger(FoodLevelChangeEvent event) {
        if (!c().getBoolean("Hunger")) event.setFoodLevel(20);
    }

    @EventHandler
    void OnSaturation(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player player)
            if (!c().getBoolean("Hunger")) player.setSaturation(20.0f);
    }

    @EventHandler
    void OnPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player)
            if (!c().getBoolean("ItemPickup"))
                if (!player.hasPermission("manage.pickup")) event.setCancelled(true);
    }

    @EventHandler
    void OnDrop(PlayerDropItemEvent event) {
        if (!c().getBoolean("ItemDrop"))
            if (!event.getPlayer().hasPermission("manage.drop")) event.setCancelled(true);
    }

    @EventHandler
    void OnBlockPlace(BlockPlaceEvent event) {
        if (!c().getBoolean("BlockPlace"))
            if (!event.getPlayer().hasPermission("manage.place")) event.setCancelled(true);
    }

    @EventHandler
    void OnBlockBreak(BlockBreakEvent event) {
        if (!c().getBoolean("BlockBreak"))
            if (!event.getPlayer().hasPermission("manage.break")) event.setCancelled(true);
    }

    @EventHandler
    void OnBucketEmpty(PlayerBucketEmptyEvent event) {
        if (!c().getBoolean("BlockPlace"))
            if (!event.getPlayer().hasPermission("manage.place")) event.setCancelled(true);
    }

    @EventHandler
    void OnBucketFill(PlayerBucketFillEvent event) {
        if (!c().getBoolean("BlockPlace"))
            if (!event.getPlayer().hasPermission("manage.place")) event.setCancelled(true);
    }

    @EventHandler
    void OnMovement(PlayerMoveEvent event) {
        if (!c().getBoolean("Movement"))
            if (!event.getPlayer().hasPermission("manage.movement")) event.setCancelled(true);
    }

    @EventHandler
    void OnInvincibility(EntityDamageEvent event) {
        if (c().getBoolean("Invincibility")) {

            if (event.getEntity() instanceof Player player) {
                event.setCancelled(true);

                player.setFireTicks(0);
            }
        }
    }

    @EventHandler
    void OnPVP(EntityDamageByEntityEvent event) {
        if (!c().getBoolean("PVP")) {
            if (event.getDamager() instanceof Player) {
                if (event.getEntity() instanceof Player) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    void OnInteract(PlayerInteractEvent event) {
        if (!c().getBoolean("Interact")) {
            if (!event.getPlayer().hasPermission("manage.interact")) event.setCancelled(true);
        }
    }
}
