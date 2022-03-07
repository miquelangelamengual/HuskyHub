package dev.husky.hub.providers;

import dev.husky.hub.utils.scoreboard.ScoreboardAdapter;
import dev.husky.hub.utils.scoreboard.ScoreboardStyle;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Hulk
 * at 06/03/2022 20:33
 * Project: HuskyHub
 * Class: ScoreboardProvider
 */

public class ScoreboardProvider implements ScoreboardAdapter {

    @Override
    public String getTitle(Player player) {
        return null;
    }

    @Override
    public List<String> getLines(Player player) {
        return null;
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return null;
    }
}
