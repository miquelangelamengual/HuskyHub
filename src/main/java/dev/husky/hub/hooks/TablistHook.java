package dev.husky.hub.hooks;

import dev.husky.hub.Hub;
import dev.husky.hub.config.TablistConfig;
import dev.husky.hub.providers.TablistProvider;
import es.hulk.tablist.Porc;
import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * Created by Hulk
 * at 07/03/2022 7:13
 * Project: HuskyHub
 * Class: TablistHook
 */

@UtilityClass
public class TablistHook {

    @Getter private Porc tablist;

    public void init() {
        if (TablistConfig.ENABLE) {
            tablist = new Porc(Hub.getInstance(), new TablistProvider());
        }
    }

}
