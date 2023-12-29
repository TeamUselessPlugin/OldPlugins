package com.teamverymc.AMonthServer;

import org.bukkit.Material;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

import static org.bukkit.Bukkit.getServer;

public class RecipeRemove {

    public static void useless_remove() {
        Iterator<Recipe> it = getServer().recipeIterator();
        Recipe recipe;
        while (it.hasNext()) {
            recipe = it.next();
            if (recipe != null && recipe.getResult().getType() == Material.ACACIA_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.BIRCH_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.CRIMSON_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.SPRUCE_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.OAK_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.DARK_OAK_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.JUNGLE_SIGN) {
                it.remove();
            } else if (recipe != null && recipe.getResult().getType() == Material.WARPED_SIGN) {
                it.remove();
            }
//            } else if (recipe != null && recipe.getResult().getType() == Material.BLACK_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.BLUE_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.BROWN_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.CYAN_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.GRAY_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.GREEN_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.LIGHT_BLUE_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.LIGHT_GRAY_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.LIME_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.MAGENTA_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.ORANGE_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.PINK_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.YELLOW_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.RED_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.PURPLE_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.WHITE_BED) {
//                it.remove();
//            } else if (recipe != null && recipe.getResult().getType() == Material.WRITABLE_BOOK) {
//                it.remove();
//            }
        }
    }
}