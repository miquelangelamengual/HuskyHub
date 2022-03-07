package dev.husky.hub.hotbar;

import dev.husky.hub.config.HotbarConfig;
import dev.husky.hub.utils.ItemBuilder;
import dev.husky.hub.utils.Utils;
import org.bukkit.Material;
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
        if (HotbarConfig.isEnabled("ENDERBUTT")) {
            enderbutt = new ItemBuilder(Material.getMaterial(HotbarConfig.getMaterial("ENDERBUTT")))
                    .data(HotbarConfig.getData("ENDERBUTT"))
                    .name(Utils.translate(HotbarConfig.getName("ENDERBUTT")))
                    .amount(HotbarConfig.getAmount("ENDERBUTT"))
                    .lore()
                    .build();
        }
    }

    public void givePlayerItems(Player player) {
        if (HotbarConfig.isEnabled("ENDERBUTT")) {
            player.getInventory().setItem(HotbarConfig.getSlot("ENDERBUTT") -1, enderbutt);
        }
    }
}
