package dev.husky.hub.queue;

import dev.husky.hub.queue.impl.Default;
import dev.husky.hub.queue.impl.EzQueue;
import dev.husky.hub.queue.impl.Portal;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

/**
 * Created by Hulk
 * at 06/03/2022 20:34
 * Project: HuskyHub
 * Class: QueueManager
 */

@Getter @Setter
public class QueueManager {

    private Queue system;
    private String queue;

    public void load() {
        if (Bukkit.getPluginManager().getPlugin("EzQueueSpigot") != null) {
            setSystem(new EzQueue());
            setQueue("EzQueue");
        } else if (Bukkit.getPluginManager().getPlugin("Portal") != null) {
            setSystem(new Portal());
            setQueue("Portal");
        } else {
            setQueue("None");
            setSystem(new Default());
        }
    }

}
