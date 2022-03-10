package dev.husky.hub.menus;

import dev.husky.hub.utils.menu.Button;
import dev.husky.hub.utils.menu.Menu;
import org.bukkit.entity.Player;

import java.util.Map;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: ServerMenu
 */

public class ServerMenu extends Menu {
    @Override
    public String getTitle(Player player) {
        return null;
    }

    @Override
    public int size(Map<Integer, Button> buttons) {
        return 0;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        return null;
    }
}
