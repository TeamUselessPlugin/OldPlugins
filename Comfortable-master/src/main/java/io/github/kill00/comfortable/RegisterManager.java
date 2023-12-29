package io.github.kill00.comfortable;

import io.github.kill00.comfortable.ItemStack.ArmorStandMeta;
import io.github.kill00.comfortable.ItemStack.ItemMeta;

public class RegisterManager {

    public void call() {
        Enchant.register();
        Gamemode.register();
        Summon.register();
        ItemMeta.register();
        ArmorStandMeta.register();
    }
}
