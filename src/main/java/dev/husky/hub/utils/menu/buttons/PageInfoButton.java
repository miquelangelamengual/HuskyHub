package dev.husky.hub.utils.menu.buttons;

import dev.husky.hub.utils.ItemBuilder;
import dev.husky.hub.utils.menu.Button;
import dev.husky.hub.utils.menu.pagination.PaginatedMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class PageInfoButton extends Button {
    private final PaginatedMenu paginatedMenu;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.NETHER_STAR).name("&ePage Info").lore("&e" + this.paginatedMenu.getPage() + "&7/&a" + this.paginatedMenu.getPages(player)).build();
    }

    @Override
    public boolean shouldCancel(final Player player, final int slot, final ClickType clickType) {
        return true;
    }

    public PageInfoButton(final PaginatedMenu paginatedMenu) {
        this.paginatedMenu = paginatedMenu;
    }
}
