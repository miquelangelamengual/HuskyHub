package dev.husky.hub.hooks;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

/**
 * Created by Hulk
 * at 07/03/2022 7:14
 * Project: HuskyHub
 * Class: PlaceholderAPIHook
 */

public class PlaceholderAPIHook {

    @Getter @Setter
    private static boolean isPlaceholderAPI;

    public static void init() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            setPlaceholderAPI(true);
        }
    }
}
