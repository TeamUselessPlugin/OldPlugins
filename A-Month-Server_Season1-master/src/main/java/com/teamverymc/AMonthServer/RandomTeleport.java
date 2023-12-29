package com.teamverymc.AMonthServer;

import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Random;

public class RandomTeleport {
    public static HashSet<Material> bad_blocks = new HashSet<>();

    static{
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.FIRE);
        bad_blocks.add(Material.CACTUS);
    }

    public static Location RT() {
        Random random = new Random();
        World world = Bukkit.getWorlds().get(0);
        WorldBorder border = world.getWorldBorder();

        int x = random.nextInt(((int)border.getSize() / 2) * 2 + 1) - ((int)border.getSize() / 2);
        int z = random.nextInt(((int)border.getSize() / 2) * 2 + 1) - ((int)border.getSize() / 2);
        int y = 256;


        Location randomLocation = new Location(world, x, y, z);
        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation) + 1;
        randomLocation.setY(y);

        return randomLocation;
    }

    public static Location Safe(){

        Location randomLocation = RT();

        while (!getSafe(randomLocation)) {

            randomLocation = RT();
        }
        return randomLocation;
    }

    public static boolean getSafe(Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);

        return !(bad_blocks.contains(below.getType())) || (block.getType().isSolid()) || (above.getType().isSolid());
    }
}
