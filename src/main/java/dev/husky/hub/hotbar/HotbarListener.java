package dev.husky.hub.hotbar;

import dev.husky.hub.Hub;
import dev.husky.hub.config.MessagesConfig;
import dev.husky.hub.menus.lobby.menu.LobbyMenu;
import dev.husky.hub.menus.server.menu.ServerMenu;
import dev.husky.hub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: HotbarListener
 */

public class HotbarListener extends Hotbar implements Listener {

    private Hotbar hotbar;

    public HotbarListener() {
        Bukkit.getPluginManager().registerEvents(this, Hub.getInstance());
        hotbar = Hub.getInstance().getHotbar();
    }

    @EventHandler
    public void onHideShow(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(hotbar.getShow())) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(online);
                }
                player.sendMessage(Utils.translate(MessagesConfig.VISIBILITY_ON));
                player.setItemInHand(Hub.getInstance().getHotbar().getHide());
            } else if (player.getItemInHand().equals(hotbar.getHide())) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(online);
                }
                player.sendMessage(Utils.translate(MessagesConfig.VISIBILITY_OFF));
                player.setItemInHand(Hub.getInstance().getHotbar().getShow());
            }
        }
    }

    @EventHandler
    public void onServerSelector(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(hotbar.getServerSelector())) {
                new ServerMenu().openMenu(player);
            }
        }
    }

    @EventHandler
    public void onLobbySelector(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(hotbar.getLobbySelector())) {
                new LobbyMenu().openMenu(player);
            }
        }
    }

    @EventHandler
    public void onEnderButt(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(hotbar.getEnderbutt())) {
                if (player.getItemInHand().getType() == Material.ENDER_PEARL
                        || player.getItemInHand().getType() == Material.SNOW_BALL) {
                    player.setVelocity(player.getLocation().getDirection().multiply(HotbarItem.getEnderbuttMultiplier("ENDER_BUTT")));
                    player.playSound(player.getLocation(), Sound.valueOf(HotbarItem.getSound("ENDER_BUTT")), 1.0f, 1.0f);
                    player.updateInventory();
                    event.setCancelled(true);
                }
            }
        }
    }
}
