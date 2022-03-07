package dev.husky.hub.listeners;

import dev.husky.hub.Hub;
import dev.husky.hub.config.MainConfig;
import dev.husky.hub.hooks.PlaceholderAPIHook;
import dev.husky.hub.utils.ServerUtil;
import dev.husky.hub.utils.Utils;
import jdk.tools.jmod.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Hulk
 * at 06/03/2022 20:34
 * Project: HuskyHub
 * Class: JoinListener
 */

public class JoinListener implements Listener {

    public JoinListener() {
        Bukkit.getPluginManager().registerEvents(this, Hub.getInstance());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (MainConfig.JOIN_MESSAGE) {
            for (String str : MainConfig.JOIN_MESSAGE_LIST) {
                if (PlaceholderAPIHook.isPlaceholderAPI()) {
                    player.sendMessage(ServerUtil.replaceText(player, PlaceholderAPI.setPlaceholders(player, str)));
                } else {
                    player.sendMessage(ServerUtil.replaceText(player, str));
                }
            }

            if (player.hasPermission(MainConfig.VIP_PERMISSION)) {
                Bukkit.broadcastMessage(Utils.translate(MainConfig.VIP_JOIN_MESSAGE));
            }

        }

        Hub.getInstance().getHotbar().givePlayerItems(player);
    }
}
