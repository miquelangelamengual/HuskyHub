package dev.husky.hub.menus.server;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ServerManager {

    private final FileConfig serverConfig = Hub.getInstance().getFileManager().getServerSelectorConfig();
    private final List<Server> servers = new ArrayList<>();

    public void load() {
        servers.clear();
        ConfigurationSection section = serverConfig.getConfiguration().getConfigurationSection("SERVER_SELECTOR.ITEMS");

        for (String key : section.getKeys(false)) {
            String displayName = serverConfig.getString("SERVER_SELECTOR.ITEMS." + key + ".DISPLAY_NAME");
            Material material = Material.valueOf(serverConfig.getString("SERVER_SELECTOR.ITEMS." + key + ".MATERIAL"));
            int data = serverConfig.getInt("SERVER_SELECTOR.ITEMS." + key + ".DATA");
            List<String> description = serverConfig.getStringList("SERVER_SELECTOR.ITEMS." + key + ".DESCRIPTION");
            int amount = serverConfig.getInt("SERVER_SELECTOR.ITEMS." + key + ".AMOUNT");
            int slot = serverConfig.getInt("SERVER_SELECTOR.ITEMS." + key + ".SLOT");
            String server = serverConfig.getString("SERVER_SELECTOR.ITEMS." + key + ".SERVER");
            boolean queue = serverConfig.getBoolean("SERVER_SELECTOR.ITEMS." + key + ".QUEUE");

            this.servers.add(new Server(key, displayName, material, data, description, amount, slot, server, queue));
        }
    }

}
