package dev.husky.hub.queue;

import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 06/03/2022 20:34
 * Project: HuskyHub
 * Class: Queue
 */

public interface Queue {

    String getServer(Player player);
    int getPosition(Player player);
    int getSize(Player player);
    boolean isInQueue(Player player);
    void sendToServer(Player player, String queueName);

}
