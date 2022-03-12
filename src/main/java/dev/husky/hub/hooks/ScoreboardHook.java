package dev.husky.hub.hooks;

import dev.husky.hub.Hub;
import dev.husky.hub.config.ScoreboardConfig;
import dev.husky.hub.providers.ScoreboardProvider;
import dev.husky.hub.utils.scoreboard.Scoreboard;
import lombok.Getter;
import lombok.experimental.UtilityClass;

/**
 * Created by Hulk
 * at 07/03/2022 7:13
 * Project: HuskyHub
 * Class: ScoreboardHook
 */

@UtilityClass
public class ScoreboardHook {

    @Getter private Scoreboard scoreboard;

    public void init() {
        if (ScoreboardConfig.ENABLE) {
            scoreboard = new Scoreboard(Hub.getInstance(), new ScoreboardProvider());
            scoreboard.setTicks(2);
        }
    }
}
