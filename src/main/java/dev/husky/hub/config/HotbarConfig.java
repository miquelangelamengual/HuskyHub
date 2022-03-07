package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;

import java.util.List;

public class HotbarConfig {

    private static final FileConfig config = Hub.getInstance().getFileManager().getHotbarConfig();

    public static boolean isEnabled(String hotbarItem) {
        return config.getBoolean("HOTBAR." + hotbarItem + ".ENABLE");
    }

    public static String getMaterial(String hotbarItem) {
        return config.getString("HOTBAR." + hotbarItem + ".MATERIAL");
    }

    public static int getData(String hotbarItem) {
        return config.getInt("HOTBAR." + hotbarItem + ".DATA");
    }

    public static String getName(String hotbarItem) {
        return config.getString("HOTBAR." + hotbarItem + ".NAME");
    }

    public static int getAmount(String hotbarItem) {
        return config.getInt("HOTBAR." + hotbarItem + ".AMOUNT");
    }

    public static List<String> getLore(String hotbarItem) {
        return config.getStringList("HOTBAR." + hotbarItem + ".LORE");
    }

    public static int getSlot(String hotbarItem) {
        return config.getInt("HOTBAR." + hotbarItem + ".SLOT");
    }
}
