package dev.husky.hub.queue.impl;

import dev.husky.hub.queue.Queue;
import me.signatured.ezqueuespigot.EzQueueAPI;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 07/03/2022 6:58
 * Project: HuskyHub
 * Class: EzQueue
 */

public class EzQueue implements Queue {

    @Override
    public String getServer(Player player) {
        return EzQueueAPI.getQueue(player.getUniqueId());
    }

    @Override
    public int getPosition(Player player) {
        return EzQueueAPI.getPosition(player.getUniqueId());
    }

    @Override
    public int getSize(Player player) {
        return EzQueueAPI.getQueueSize(getServer(player));
    }

    @Override
    public boolean isInQueue(Player player) {
        return EzQueueAPI.getQueue(player.getUniqueId()) != null;
    }

    @Override
    public void sendToServer(Player player, String queueName) {
        EzQueueAPI.addToQueue(player, queueName);
    }
}
