package dev.husky.hub.outfits;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.rank.Rank;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 * Created by Hulk
 * at 06/03/2022 20:33
 * Project: HuskyHub
 * Class: Outfit
 */

public class Outfit {

    public Outfit(Player player) {
        this.giveOutfit(player);
    }

    public void giveOutfit(Player player) {
        Rank rank = Hub.getInstance().getRankManager().getRank();
        FileConfig config = Hub.getInstance().getFileManager().getOutfitConfig();

        ConfigurationSection section = config.getConfiguration().getConfigurationSection("OUTFITS");

        if (section.getString(rank.getName(player.getUniqueId())) == null) {
            throw new IllegalArgumentException("Invalid rank name for " + section.getString(rank.getName(player.getUniqueId())));
        }

        switch (section.getString(rank.getName(player.getUniqueId()))) {
            case "RED":
                getEquipOutfit(player, Color.RED);
                break;
            case "GREEN":
                getEquipOutfit(player, Color.GREEN);
                break;
            case "BLUE":
                getEquipOutfit(player, Color.BLUE);
                break;
            case "YELLOW":
                getEquipOutfit(player, Color.YELLOW);
                break;
            case "PURPLE":
                getEquipOutfit(player, Color.PURPLE);
                break;
            case "ORANGE":
                getEquipOutfit(player, Color.ORANGE);
                break;
            case "WHITE":
                getEquipOutfit(player, Color.WHITE);
                break;
            case "BLACK":
                getEquipOutfit(player, Color.BLACK);
                break;
            case "GRAY":
                getEquipOutfit(player, Color.GRAY);
                break;
            case "MAROON":
                getEquipOutfit(player, Color.MAROON);
                break;
            case "OLIVE":
                getEquipOutfit(player, Color.OLIVE);
                break;
            case "NAVY":
                getEquipOutfit(player, Color.NAVY);
                break;
            case "TEAL":
                getEquipOutfit(player, Color.TEAL);
                break;
            case "LIME":
                getEquipOutfit(player, Color.LIME);
                break;
            case "AQUA":
                getEquipOutfit(player, Color.AQUA);
                break;
            case "FUCHSIA":
                getEquipOutfit(player, Color.FUCHSIA);
                break;
            case "SILVER":
                getEquipOutfit(player, Color.SILVER);
                break;
            case "RAINBOW":
                OutfitRainbow armor = new OutfitRainbow(player, 0, 0, 255, 0, 0, 0, 0, 0, 0);
                armor.runTaskTimerAsynchronously(Hub.getInstance(), 0L, 1L);
                break;
        }
    }

    private void getEquipOutfit(Player player, Color color) {
        player.getInventory().setArmorContents(new ItemStack[]{
                new ItemStack(Material.LEATHER_BOOTS, 1),
                new ItemStack(Material.LEATHER_LEGGINGS, 1),
                new ItemStack(Material.LEATHER_CHESTPLATE, 1),
                new ItemStack(Material.LEATHER_HELMET, 1)
        });
        for (ItemStack armor : player.getInventory().getArmorContents()) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) armor.getItemMeta();
            leatherArmorMeta.setColor(color);
            armor.setItemMeta(leatherArmorMeta);
        }
    }

}
