package dev.husky.hub.utils.rank.impl;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.rank.Rank;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PermissionsEx implements Rank {

    @Override
    public String getName(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return Hub.getInstance().getRankManager().getChat().getPrimaryGroup(
                String.valueOf(Hub.getInstance().getRankManager().getPlugin().getServer().getWorlds().get(0).getName()), player);
    }

    @Override
    public String getPrefix(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return Hub.getInstance().getRankManager().getChat().getPlayerPrefix(String.valueOf(
                Hub.getInstance().getRankManager().getPlugin().getServer().getWorlds().get(0).getName()), player);
    }

    @Override
    public String getSuffix(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return Hub.getInstance().getRankManager().getChat().getPlayerSuffix(String.valueOf(
                Hub.getInstance().getRankManager().getPlugin().getServer().getWorlds().get(0).getName()), player);
    }

    @Override
    public String getColor(UUID uuid) {
        OfflinePlayer player = Bukkit.getOfflinePlayer(uuid);
        return Hub.getInstance().getRankManager().getChat().getPrimaryGroup(String.valueOf(
                Hub.getInstance().getRankManager().getPlugin().getServer().getWorlds().get(0).getName()), player);
    }

    @Override
    public String getRealName(Player player) {
        return null;
    }

    @Override
    public int getWeight(UUID uuid) {
        return 0;
    }
}
