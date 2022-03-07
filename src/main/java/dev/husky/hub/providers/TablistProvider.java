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

        if (skinTab.contains("%player%")) {
            skinDefault = Skin.getSkin(player);
        }
        if (skinTab.contains("%discord%")) {
            skinDefault = Skin.DISCORD_SKIN;
        }
        if (skinTab.contains("%youtube%")) {
            skinDefault = Skin.YOUTUBE_SKIN;
        }
        if (skinTab.contains("%twitter%")) {
            skinDefault = Skin.TWITTER_SKIN;

        }
        if (skinTab.contains("%facebook%")) {
            skinDefault = Skin.FACEBOOK_SKIN;

        }
        if (skinTab.contains("%store%")) {
            skinDefault = Skin.STORE_SKIN;
        }

        if (skinTab.contains("%green%")) {
            skinDefault = Skin.getDot(ChatColor.GREEN);
        }
        if (skinTab.contains("%blue%")) {
            skinDefault = Skin.getDot(ChatColor.BLUE);
        }
        if (skinTab.contains("%dark_blue%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_BLUE);
        }
        if (skinTab.contains("%dark_aqua%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_AQUA);
        }
        if (skinTab.contains("%dark_purple%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_PURPLE);
        }
        if (skinTab.contains("%light_purple%")) {
            skinDefault = Skin.getDot(ChatColor.LIGHT_PURPLE);
        }
        if (skinTab.contains("%gray%")) {
            skinDefault = Skin.getDot(ChatColor.GRAY);
        }
        if (skinTab.contains("%red%")) {
            skinDefault = Skin.getDot(ChatColor.RED);
        }
        if (skinTab.contains("%yellow%")) {
            skinDefault = Skin.getDot(ChatColor.YELLOW);
        }
        if (skinTab.contains("%dark_green%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_GREEN);
        }
        if (skinTab.contains("%dark_red%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_RED);
        }
        if (skinTab.contains("%gold%")) {
            skinDefault = Skin.getDot(ChatColor.GOLD);
        }
        if (skinTab.contains("%aqua%")) {
            skinDefault = Skin.getDot(ChatColor.AQUA);
        }
        if (skinTab.contains("%white%")) {
            skinDefault = Skin.getDot(ChatColor.WHITE);
        }
        if (skinTab.contains("%dark_gray%")) {
            skinDefault = Skin.getDot(ChatColor.DARK_GRAY);
        }
        if (skinTab.contains("%black%")) {
            skinDefault = Skin.getDot(ChatColor.BLACK);
        }
        if (skinTab.contains("%warning%")) {
            skinDefault = Skin.WARNING_SKIN;
        }
        if (skinTab.contains("%website%")) {
            skinDefault = Skin.WEBSITE_SKIN;
        }
        if (skinTab.contains("%queue%")) {
            skinDefault = Skin.QUEUE_SKIN;
        }
        if (skinTab.contains("%information%")) {
            skinDefault = Skin.INFORMATION_SKIN;
        }
        if (skinTab.contains("%wood_shield%")) {
            skinDefault = Skin.WOOD_SHIELD_SKIN;
        }
        if (skinTab.contains("%diamond_shield%")) {
            skinDefault = Skin.DIAMOND_SHIELD_SKIN;
        }
        if (skinTab.contains("%bow%")) {
            skinDefault = Skin.BOW_SKIN;
        }
        if (skinTab.contains("%potion%")) {
            skinDefault = Skin.POTION_SKIN;
        }
        if (skinTab.contains("%telegram%")) {
            skinDefault = Skin.TELEGRAM_SKIN;
        }
        if (skinTab.contains("%enderchest%")) {
            skinDefault = Skin.ENDERCHEST_SKIN;
        }
        if (skinTab.contains("%coin%")) {
            skinDefault = Skin.COIN_SKIN;
        }
        if (skinTab.contains("%heart%")) {
            skinDefault = Skin.HEART_SKIN;
        }
        if (skinTab.contains("%earth%")) {
            skinDefault = Skin.EARTH_SKIN;
        }
        if (skinTab.contains("%crown%")) {
            skinDefault = Skin.CROWN_SKIN;
        }

        return Skin.DEFAULT;
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
