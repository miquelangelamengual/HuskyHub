package dev.husky.hub.providers;

import es.hulk.tablist.objects.TabLayout;
import es.hulk.tablist.utils.TabProvider;
import org.bukkit.entity.Player;

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
        return null;
    }

    @Override
    public List<String> getFooter(Player player) {
        return null;
    }

    @Override
    public List<String> getHeader(Player player) {
        return null;
    }
}
