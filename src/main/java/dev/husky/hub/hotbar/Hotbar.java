package dev.husky.hub.hotbar;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: Hotbar
 */

public class Hotbar {

    private ItemStack enderbutt;
    private ItemStack serverSelector;
    private ItemStack lobbySelector;
    private ItemStack hide;
    private ItemStack show;

    public void init() {
        if (HotbarItem.isEnabled("ENDERBUTT")) {
            enderbutt = HotbarItem.createItem("ENDERBUTT");
        }

        if (HotbarItem.isEnabled("SERVER_SELECTOR")) {
            serverSelector = HotbarItem.createItem("SERVER_SELECTOR");
        }
    }

    public void givePlayerItems(Player player) {
        if (HotbarItem.isEnabled("ENDERBUTT")) {
            player.getInventory().setItem(HotbarItem.getSlot("ENDERBUTT") -1, enderbutt);
        }
    }
}
