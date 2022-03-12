package dev.husky.hub.listeners;

import dev.husky.hub.Hub;
import dev.husky.hub.config.MainConfig;
import dev.husky.hub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Hulk
 * at 06/03/2022 20:34
 * Project: HuskyHub
 * Class: QuitListener
 */

public class QuitListener implements Listener {

    public QuitListener() {
        Bukkit.getPluginManager().registerEvents(this, Hub.getInstance());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);

        if (player.hasPermission(MainConfig.VIP_PERMISSION)) {
            Bukkit.broadcastMessage(Utils.translate(MainConfig.VIP_LEAVE_MESSAGE));
        }
    }
}
