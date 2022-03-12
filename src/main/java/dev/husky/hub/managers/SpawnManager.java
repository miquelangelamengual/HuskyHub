package dev.husky.hub.managers;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 07/03/2022 15:13
 * Project: HuskyHub
 * Class: SpawnManager
 */

public class SpawnManager {

    private final FileConfig config = Hub.getInstance().getFileManager().getLocationsConfig();

    public Location getSpawnLocation() {
        World world = Bukkit.getWorld(config.getString("SPAWN_LOCATION.WORLD"));
        double x = config.getDouble("SPAWN_LOCATION.X");
        double y = config.getDouble("SPAWN_LOCATION.Y");
        double z = config.getDouble("SPAWN_LOCATION.Z");
        double yaw = config.getDouble("SPAWN_LOCATION.YAW");
        double pitch = config.getDouble("SPAWN_LOCATION.PITCH");
        return new Location(world, x, y, z, (float) yaw, (float) pitch);
    }

    public void setSpawnLocation(Location location) {
        config.getConfiguration().set("SPAWN_LOCATION.WORLD", location.getWorld().getName());
        config.getConfiguration().set("SPAWN_LOCATION.X", location.getX());
        config.getConfiguration().set("SPAWN_LOCATION.Y", location.getY());
        config.getConfiguration().set("SPAWN_LOCATION.Z", location.getZ());
        config.getConfiguration().set("SPAWN_LOCATION.YAW", location.getYaw());
        config.getConfiguration().set("SPAWN_LOCATION.PITCH", location.getPitch());
        config.save();
    }

    public void teleportPlayer(Player player) {
        if (this.getSpawnLocation() == null) {
            player.teleport(player.getWorld().getSpawnLocation());
        } else {
            player.teleport(this.getSpawnLocation());
        }
    }

}
