package dev.husky.hub.queue.impl;

import dev.husky.hub.queue.Queue;
import org.bukkit.entity.Player;

public class Default implements Queue {

    @Override
    public String getServer(Player player) {
        return null;
    }

    @Override
    public int getPosition(Player player) {
        return 0;
    }

    @Override
    public int getSize(Player player) {
        return 0;
    }

    @Override
    public boolean isInQueue(Player player) {
        return false;
    }

    @Override
    public void sendToServer(Player player, String queueName) {

    }
}
