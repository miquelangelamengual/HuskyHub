package dev.husky.hub.utils.menu.pagination;

import dev.husky.hub.utils.menu.Menu;
import dev.husky.hub.utils.menu.buttons.BackButton;
import lombok.NonNull;
import org.bukkit.entity.Player;
import dev.husky.hub.utils.menu.Button;

import java.util.HashMap;
import java.util.Map;

public class ViewAllPagesMenu extends Menu {
    @NonNull
    PaginatedMenu menu;

    @Override
    public String getTitle(final Player player) {
        return "Jump to page";
    }

    @Override
    public Map<Integer, Button> getButtons(final Player player) {
        final HashMap<Integer, Button> buttons = new HashMap<Integer, Button>();
        buttons.put(0, new BackButton(this.menu));
        int index = 10;
        for (int i = 1; i <= this.menu.getPages(player); ++i) {
            buttons.put(index++, new JumpToPageButton(i, this.menu, this.menu.getPage() == i));
            if ((index - 8) % 9 == 0) {
                index += 2;
            }
        }
        return buttons;
    }

    @Override
    public boolean isAutoUpdate() {
        return true;
    }

    @NonNull
    public PaginatedMenu getMenu() {
        return this.menu;
    }
}
