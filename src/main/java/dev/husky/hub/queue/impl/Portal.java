package dev.husky.hub.queue.impl;

import dev.husky.hub.queue.Queue;
import dev.husky.hub.utils.Utils;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 07/03/2022 6:58
 * Project: HuskyHub
 * Class: Portal
 */

public class Portal implements Queue {

    @Override
    public String getServer(Player player) {
        me.joeleoli.portal.shared.queue.Queue queue = me.joeleoli.portal.shared.queue.Queue.getByPlayer(player.getUniqueId());
        return queue.getName();
    }

    @Override
    public int getPosition(Player player) {
        me.joeleoli.portal.shared.queue.Queue queue = me.joeleoli.portal.shared.queue.Queue.getByPlayer(player.getUniqueId());
        return queue.getPosition(player.getUniqueId());
    }

    @Override
    public int getSize(Player player) {
        me.joeleoli.portal.shared.queue.Queue queue = me.joeleoli.portal.shared.queue.Queue.getByPlayer(player.getUniqueId());
        return queue.getPlayers().size();
    }

    @Override
    public boolean isInQueue(Player player) {
        me.joeleoli.portal.shared.queue.Queue queue = me.joeleoli.portal.shared.queue.Queue.getByPlayer(player.getUniqueId());
        return queue != null;
    }

    @Override
    public void sendToServer(Player player, String queueName) {
        me.joeleoli.portal.shared.queue.Queue queue = me.joeleoli.portal.shared.queue.Queue.getByName(queueName);

        if (queue == null) {
            player.sendMessage(Utils.translate("&cQueue '" + queueName + "' does not exist."));
            return;
        }

        queue.sendPlayer(player, queueName);
    }
}
