package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Created by Hulk
 * at 07/03/2022 7:00
 * Project: HuskyHub
 * Class: ScoreboardConfig
 */

@UtilityClass
public class ScoreboardConfig {

    private final FileConfig config = Hub.getInstance().getFileManager().getScoreboardConfig();

    public boolean ENABLE;

    public String TITLE;

    public List<String> MAIN;
    public List<String> QUEUE;

    public void init() {
        ENABLE = config.getBoolean("SCOREBOARD.ENABLE");
        TITLE = config.getString("SCOREBOARD.TITLE");

        MAIN = config.getStringList("SCOREBOARD.MAIN");
        QUEUE = config.getStringList("SCOREBOARD.QUEUE");
    }

}
