package dev.husky.hub.menus.lobby.menu;

import dev.husky.hub.Hub;
import dev.husky.hub.menus.lobby.Lobby;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.menu.Button;
import dev.husky.hub.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 06/03/2022 20:33
 * Project: HuskyHub
 * Class: LobbyMenu
 */

public class LobbyMenu extends Menu {

    private final FileConfig config = Hub.getInstance().getFileManager().getLobbySelectorConfig();

    @Override
    public String getTitle(Player player) {
        return config.getString("LOBBY_SELECTOR.TITLE");
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return config.getInt("LOBBY_SELECTOR.SIZE");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        for (Lobby lobby : Hub.getInstance().getLobbyManager().getLobbies()) buttons.put(lobby.getSlot(), new LobbyButton(lobby));

        return buttons;
    }
}
