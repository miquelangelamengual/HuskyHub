package dev.husky.hub.utils.menu.buttons;

import dev.husky.hub.utils.ItemBuilder;
import dev.husky.hub.utils.menu.Button;
import dev.husky.hub.utils.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

public class BackButton extends Button {
    private final Menu back;

    @Override
    public ItemStack getButtonItem(final Player player) {
        return new ItemBuilder(Material.BED).name("&cGo back").build();
    }

    @Override
    public void clicked(final Player player, final int i, final ClickType clickType, final int hb) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }

    public BackButton(final Menu back) {
        this.back = back;
    }
}
