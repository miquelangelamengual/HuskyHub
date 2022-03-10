package dev.husky.hub.hotbar;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.ItemBuilder;
import dev.husky.hub.utils.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class HotbarItem {

    private static final FileConfig config = Hub.getInstance().getFileManager().getHotbarConfig();

    public static boolean isEnabled(String hotbarItem) {
        return config.getBoolean("HOTBAR." + hotbarItem + ".ENABLE");
    }

    public static int getSlot(String hotbarItem) {
        return config.getInt("HOTBAR." + hotbarItem + ".SLOT");
    }

    public static ItemStack createItem(String hotbarItem) {
        return new ItemBuilder
                (Material.getMaterial(config.getString("HOTBAR." + hotbarItem + ".MATERIAL")))
                .data(config.getInt("HOTBAR." + hotbarItem + ".DATA"))
                .name(Utils.translate(config.getString("HOTBAR." + hotbarItem + ".NAME")))
                .amount(config.getInt("HOTBAR." + hotbarItem + ".AMOUNT"))
                .lore(Utils.translate(config.getStringList("HOTBAR." + hotbarItem + ".LORE")))
                .build();
    }

    public static int getEnderbuttMultiplier(String hotbarItem) {
        return config.getInt("HOTBAR." + hotbarItem + ".VELOCITY");
    }

    public static String getSound(String hotbarItem) {
        return config.getString("HOTBAR." + hotbarItem + ".SOUND");
    }

}
