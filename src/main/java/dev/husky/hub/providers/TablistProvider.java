package dev.husky.hub.providers;

import dev.husky.hub.config.TablistConfig;
import dev.husky.hub.hooks.PlaceholderAPIHook;
import dev.husky.hub.utils.ServerUtil;
import es.hulk.tablist.objects.TabColumn;
import es.hulk.tablist.objects.TabLayout;
import es.hulk.tablist.skin.Skin;
import es.hulk.tablist.utils.TabProvider;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hulk
 * at 06/03/2022 20:33
 * Project: HuskyHub
 * Class: TablistProvider
 */

public class TablistProvider implements TabProvider {

    @Override
    public Set<TabLayout> getProvider(Player player) {
        Set<TabLayout> layoutSet = new HashSet<>();

        for (int i = 1; i <= 20; i++) {
            layoutSet.add(new TabLayout(TabColumn.LEFT, i )
                    .setText(ServerUtil.replaceText(player, TablistConfig.getLines("LEFT", i, "TEXT")))
                    .setSkin(getSkin(player, TablistConfig.getLines("LEFT", i, "SKIN"))));
            layoutSet.add(new TabLayout(TabColumn.MIDDLE, i )
                    .setText(ServerUtil.replaceText(player, TablistConfig.getLines("MIDDLE", i, "TEXT")))
                    .setSkin(getSkin(player, TablistConfig.getLines("MIDDLE", i, "SKIN"))));
            layoutSet.add(new TabLayout(TabColumn.RIGHT, i )
                    .setText(ServerUtil.replaceText(player, TablistConfig.getLines("RIGHT", i, "TEXT")))
                    .setSkin(getSkin(player, TablistConfig.getLines("RIGHT", i, "SKIN"))));
            layoutSet.add(new TabLayout(TabColumn.FAR_RIGHT, i )
                    .setText(ServerUtil.replaceText(player, TablistConfig.getLines("FAR_RIGHT", i, "TEXT")))
                    .setSkin(getSkin(player, TablistConfig.getLines("FAR_RIGHT", i, "SKIN"))));
        }
        return layoutSet;
    }

    public Skin getSkin(Player player, String skinTab) {
        Skin skinDefault = Skin.DEFAULT;

        if (skinTab.contains("%PLAYER%")) {
            skinDefault = Skin.getSkin(player);
        }
        if (skinTab.contains("%DISCORD%")) {
            skinDefault = Skin.DISCORD_SKIN;
        }
        if (skinTab.contains("%YOUTUBE%")) {
            skinDefault = Skin.YOUTUBE_SKIN;
        }
        if (skinTab.contains("%TWITTER%")) {
            skinDefault = Skin.TWITTER_SKIN;

        }
        if (skinTab.contains("%FACEBOOK%")) {
            skinDefault = Skin.FACEBOOK_SKIN;

        }
        if (skinTab.contains("%STORE%")) {
            skinDefault = Skin.STORE_SKIN;
        }

        if (skinTab.contains("%GREEN%")) {
            skinDefault = Skin.getDot(ChatColor.GREEN);
        }
        if (skinTab.contains("%BLUE%")) {
            skinDefault = Skin.getDot(ChatColor.BLUE);
        }
        if (skinTab.contains("%DARK_BLUE%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_BLUE);
        }
        if (skinTab.contains("%DARK_AQUA%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_AQUA);
        }
        if (skinTab.contains("%DARK_PURPLE%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_PURPLE);
        }
        if (skinTab.contains("%LIGHT_PURPLE%")) {
            skinDefault = Skin.getDot(ChatColor.LIGHT_PURPLE);
        }
        if (skinTab.contains("%GRAY%")) {
            skinDefault = Skin.getDot(ChatColor.GRAY);
        }
        if (skinTab.contains("%RED%")) {
            skinDefault = Skin.getDot(ChatColor.RED);
        }
        if (skinTab.contains("%YELLOW%")) {
            skinDefault = Skin.getDot(ChatColor.YELLOW);
        }
        if (skinTab.contains("%DARK_GREEN%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_GREEN);
        }
        if (skinTab.contains("%DARK_RED%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_RED);
        }
        if (skinTab.contains("%GOLD%")) {
            skinDefault = Skin.getDot(ChatColor.GOLD);
        }
        if (skinTab.contains("%AQUA%")) {
            skinDefault = Skin.getDot(ChatColor.AQUA);
        }
        if (skinTab.contains("%WHITE%")) {
            skinDefault = Skin.getDot(ChatColor.WHITE);
        }
        if (skinTab.contains("%DARK_GRAY%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_GRAY);
        }
        if (skinTab.contains("%BLACK%")) {
            skinDefault = Skin.getDot(ChatColor.BLACK);
        }
        if (skinTab.contains("%WARNING%")) {
            skinDefault = Skin.WARNING_SKIN;
        }
        if (skinTab.contains("%WEBSITE%")) {
            skinDefault = Skin.WEBSITE_SKIN;
        }
        if (skinTab.contains("%QUEUE%")) {
            skinDefault = Skin.QUEUE_SKIN;
        }
        if (skinTab.contains("%INFORMATION%")) {
            skinDefault = Skin.INFORMATION_SKIN;
        }
        if (skinTab.contains("%WOOD_SHIELD%")) {
            skinDefault = Skin.WOOD_SHIELD_SKIN;
        }
        if (skinTab.contains("%DIAMOND_SHIELD%")) {
            skinDefault = Skin.DIAMOND_SHIELD_SKIN;
        }
        if (skinTab.contains("%BOW%")) {
            skinDefault = Skin.BOW_SKIN;
        }
        if (skinTab.contains("%POTION%")) {
            skinDefault = Skin.POTION_SKIN;
        }
        if (skinTab.contains("%TELEGRAM%")) {
            skinDefault = Skin.TELEGRAM_SKIN;
        }
        if (skinTab.contains("%ENDERCHEST%")) {
            skinDefault = Skin.ENDERCHEST_SKIN;
        }
        if (skinTab.contains("%COIN%")) {
            skinDefault = Skin.COIN_SKIN;
        }
        if (skinTab.contains("%HEART%")) {
            skinDefault = Skin.HEART_SKIN;
        }
        if (skinTab.contains("%EARTH%")) {
            skinDefault = Skin.EARTH_SKIN;
        }
        if (skinTab.contains("%CROWN%")) {
            skinDefault = Skin.CROWN_SKIN;
        }
        return skinDefault;
    }

    @Override
    public List<String> getFooter(Player player) {
        List<String> footer = new ArrayList<>();

        for (String str : TablistConfig.FOOTER) {
            footer.add(ServerUtil.replaceText(player, str));
            if (PlaceholderAPIHook.isPlaceholderAPI()) {
                footer.add(PlaceholderAPI.setPlaceholders(player, str));
            }
        }

        return footer;
    }

    @Override
    public List<String> getHeader(Player player) {
        List<String> header = new ArrayList<>();

        for (String str : TablistConfig.HEADER) {
            header.add(ServerUtil.replaceText(player, str));
            if (PlaceholderAPIHook.isPlaceholderAPI()) {
                header.add(PlaceholderAPI.setPlaceholders(player, str));
            }
        }

        return header;
    }
}
