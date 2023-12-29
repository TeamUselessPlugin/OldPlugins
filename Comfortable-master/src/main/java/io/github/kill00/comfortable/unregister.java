package io.github.kill00.comfortable;

import dev.jorel.commandapi.CommandAPI;

public class unregister {

    public static void get() {
        CommandAPI.unregister("enchant", true);
        CommandAPI.unregister("gamemode", true);
//        CommandAPI.unregister("summon", true);
    }
}
