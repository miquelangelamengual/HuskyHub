package dev.husky.hub.menus.server.menu;

import dev.husky.hub.Hub;
import dev.husky.hub.menus.server.Server;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.menu.Button;
import dev.husky.hub.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: ServerMenu
 */

public class ServerMenu extends Menu {

    private final FileConfig config = Hub.getInstance().getFileManager().getServerSelectorConfig();

    @Override
    public String getTitle(Player player) {
        return config.getString("SERVER_SELECTOR.TITLE");
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return config.getInt("SERVER_SELECTOR.SIZE");
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        Map<Integer, Button> buttons = new HashMap<>();

        for (Server server : Hub.getInstance().getServerManager().getServers()) {
            buttons.put(server.getSlot(), new ServerButton(server));
        }

        return buttons;
    }
}
