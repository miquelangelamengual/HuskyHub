package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Created by Hulk
 * at 07/03/2022 7:09
 * Project: HuskyHub
 * Class: TablistConfig
 */

@UtilityClass
public class TablistConfig {

    private final FileConfig config = Hub.getInstance().getFileManager().getTablistConfig();

    public boolean ENABLE;
    public List<String> HEADER;
    public List<String> FOOTER;

    public void init() {
        ENABLE = config.getBoolean("TABLIST.ENABLE");
        HEADER = config.getStringList("TABLIST.HEADER");
        FOOTER = config.getStringList("TABLIST.FOOTER");
    }

    public String getLines(String column, int pos, String textOrSkin) {
        return config.getString("TABLIST." + column + "." + pos + "." + textOrSkin);
    }
}
