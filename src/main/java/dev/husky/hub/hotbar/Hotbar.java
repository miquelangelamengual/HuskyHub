package dev.husky.hub.hotbar;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: Hotbar
 */

@Getter
@Setter
public class Hotbar {

    private ItemStack enderbutt;
    private ItemStack serverSelector;
    private ItemStack lobbySelector;
    private ItemStack hide;
    private ItemStack show;

    public void init() {
        if (HotbarItem.isEnabled("ENDERBUTT")) enderbutt = HotbarItem.createItem("ENDERBUTT");
        if (HotbarItem.isEnabled("SERVER_SELECTOR")) serverSelector = HotbarItem.createItem("SERVER_SELECTOR");
        if (HotbarItem.isEnabled("LOBBY_SELECTOR")) lobbySelector = HotbarItem.createItem("LOBBY_SELECTOR");
        if (HotbarItem.isEnabled("PLAYER_VISIBILITY_OFF")) hide = HotbarItem.createItem("PLAYER_VISIBILITY_OFF");
        if (HotbarItem.isEnabled("PLAYER_VISIBILITY_ON")) show = HotbarItem.createItem("PLAYER_VISIBILITY_ON");
    }

    public void givePlayerItems(Player player) {
        if (HotbarItem.isEnabled("ENDERBUTT"))
            player.getInventory().setItem(HotbarItem.getSlot("ENDERBUTT") - 1, enderbutt);
        if (HotbarItem.isEnabled("SERVER_SELECTOR"))
            player.getInventory().setItem(HotbarItem.getSlot("SERVER_SELECTOR") - 1, serverSelector);
        if (HotbarItem.isEnabled("LOBBY_SELECTOR"))
            player.getInventory().setItem(HotbarItem.getSlot("LOBBY_SELECTOR") - 1, lobbySelector);
        if (HotbarItem.isEnabled("PLAYER_VISIBILITY_OFF"))
            player.getInventory().setItem(HotbarItem.getSlot("PLAYER_VISIBILITY_OFF") - 1, hide);
        if (HotbarItem.isEnabled("PLAYER_VISIBILITY_ON"))
            player.getInventory().setItem(HotbarItem.getSlot("PLAYER_VISIBILITY_OFF") - 1, show);
    }
}
