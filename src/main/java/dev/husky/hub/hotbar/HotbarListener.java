package dev.husky.hub.hotbar;

import dev.husky.hub.Hub;
import dev.husky.hub.config.MessagesConfig;
import dev.husky.hub.utils.Utils;
import org.bukkit.Bukkit;
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

    public HotbarListener() {
        Bukkit.getPluginManager().registerEvents(this, Hub.getInstance());
    }

    @EventHandler
    public void onHideShow(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().equals(Hub.getInstance().getHotbar().getShow())) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(online);
                }
                player.sendMessage(Utils.translate(MessagesConfig.VISIBILITY_ON));
                player.setItemInHand(Hub.getInstance().getHotbar().getHide());
            } else if (player.getItemInHand().equals(Hub.getInstance().getHotbar().getHide())) {
                for (Player online : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(online);
                }
                player.sendMessage(Utils.translate(MessagesConfig.VISIBILITY_OFF));
                player.setItemInHand(Hub.getInstance().getHotbar().getShow());
            }
        }
    }
}
