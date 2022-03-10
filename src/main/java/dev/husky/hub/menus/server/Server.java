package dev.husky.hub.menus.server;

import dev.husky.hub.utils.ItemBuilder;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@Getter
public class Server {

    private String name;
    private String displayName;
    private Material material;
    private int data;
    private List<String> lore;
    private int amount;
    private int slot;
    private String server;
    private boolean queue;

    public Server(String name, String displayName, Material material, int data, List<String> lore, int amount, int slot, String server, boolean queue) {
        this.name = name;
        this.displayName = displayName;
        this.material = material;
        this.data = data;
        this.lore = lore;
        this.amount = amount;
        this.slot = slot;
        this.server = server;
        this.queue = queue;
    }

    public ItemStack createItem() {
        return new ItemBuilder(material)
                .data(data)
                .lore(lore)
                .amount(amount)
                .name(displayName)
                .build();
    }
}
