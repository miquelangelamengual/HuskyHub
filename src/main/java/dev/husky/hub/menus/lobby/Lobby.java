package dev.husky.hub.menus.lobby;

import dev.husky.hub.utils.ItemBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
public class Lobby {

    private final String displayName;
    private final List<String> lore;
    private final Material material;
    private final int data;
    private final int amount;
    private final int slot;
    private final String lobby;

    public Lobby(String displayName, List<String> lore, Material material, int data, int amount, int slot, String lobby) {
        this.displayName = displayName;
        this.lore = lore;
        this.material = material;
        this.data = data;
        this.amount = amount;
        this.slot = slot;
        this.lobby = lobby;
    }

    public ItemStack createItem() {
        return new ItemBuilder(material)
                .data(data)
                .name(displayName)
                .lore(lore)
                .amount(amount)
                .build();
    }
}