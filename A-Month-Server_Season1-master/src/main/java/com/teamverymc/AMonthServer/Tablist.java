package com.teamverymc.AMonthServer;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Objects;

public class Tablist {

    public void update() {
        var packet = new PacketContainer(PacketType.Play.Server.PLAYER_INFO);
        var list = new ArrayList<PlayerInfoData>();

        for (var o : Bukkit.getOfflinePlayers()) {
            var profile = (o instanceof Player) ? WrappedGameProfile.fromPlayer((Player) o) : WrappedGameProfile.fromOfflinePlayer(o).withName(o.getName());
            list.add(new PlayerInfoData(
                    profile,
                    0,
                    EnumWrappers.NativeGameMode.SURVIVAL,
                    WrappedChatComponent.fromText(Objects.requireNonNull(o.getName()))
            ));
        }

        packet.getPlayerInfoAction().write(0, EnumWrappers.PlayerInfoAction.ADD_PLAYER);
        packet.getPlayerInfoDataLists().write(0, list);

        for (var player : Bukkit.getOnlinePlayers()) {
            try {
                ProtocolLibrary.getProtocolManager().sendServerPacket(player, packet);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
