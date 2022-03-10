package dev.husky.hub.menus.lobby;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LobbyManager {

    private final FileConfig lobbyConfig = Hub.getInstance().getFileManager().getLobbySelectorConfig();
    private final List<Lobby> lobbies = new ArrayList<>();

    public void load() {
        this.lobbies.clear();
        ConfigurationSection section = lobbyConfig.getConfiguration().getConfigurationSection("LOBBY_SELECTOR.ITEMS");

        for (String item : section.getKeys(false)) {
            String displayName = lobbyConfig.getString("LOBBY_SELECTOR.ITEMS." + item + ".DISPLAY_NAME");
            List<String> description = lobbyConfig.getStringList("LOBBY_SELECTOR.ITEMS." + item + ".DESCRIPTION");
            Material material = Material.valueOf(lobbyConfig.getString("LOBBY_SELECTOR.ITEMS." + item + ".MATERIAL"));
            int data = lobbyConfig.getInt("LOBBY_SELECTOR.ITEMS." + item + ".DATA");
            int slot = lobbyConfig.getInt("LOBBY_SELECTOR.ITEMS." + item + ".SLOT");
            String server = lobbyConfig.getString("LOBBY_SELECTOR.ITEMS." + item + ".SERVER");
            int amount = lobbyConfig.getInt("LOBBY_SELECTOR.ITEMS." + item + ".AMOUNT");

            this.lobbies.add(new Lobby(displayName, description, material, data, amount, slot, server));
        }
    }
}
