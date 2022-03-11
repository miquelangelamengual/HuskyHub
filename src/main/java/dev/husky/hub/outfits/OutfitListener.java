package dev.husky.hub.outfits;

import dev.husky.hub.Hub;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Hulk
 * at 06/03/2022 20:33
 * Project: HuskyHub
 * Class: OutfitListener
 */

public class OutfitListener implements Listener {

    public OutfitListener() {
        Bukkit.getPluginManager().registerEvents(this, Hub.getInstance());
    }

    @EventHandler
    public void equipOutfit(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().setBoots(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setHelmet(null);
        new Outfit(player);
    }
}
