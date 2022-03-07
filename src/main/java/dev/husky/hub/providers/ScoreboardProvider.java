package dev.husky.hub.providers;

import dev.husky.hub.Hub;
import dev.husky.hub.config.ScoreboardConfig;
import dev.husky.hub.queue.Queue;
import dev.husky.hub.queue.QueueManager;
import dev.husky.hub.utils.ServerUtil;
import dev.husky.hub.utils.Utils;
import dev.husky.hub.utils.scoreboard.Scoreboard;
import dev.husky.hub.utils.scoreboard.ScoreboardAdapter;
import dev.husky.hub.utils.scoreboard.ScoreboardStyle;
import org.bukkit.entity.Player;

import java.util.ArrayList;
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
        return Utils.translate(ScoreboardConfig.TITLE);
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> lines = new ArrayList<>();
        Queue queue = Hub.getInstance().getQueueManager().getSystem();

        for (String str : ScoreboardConfig.MAIN) {
            if (str.contains("%QUEUE")) {
                if (queue.isInQueue(player)) {
                    for (String q : ScoreboardConfig.QUEUE) {
                        lines.add(q
                                .replaceAll("%POSITION%", String.valueOf(queue.getPosition(player)))
                                .replaceAll("%TOTAL%", String.valueOf(queue.getSize(player)))
                                .replaceAll("%SERVER%", queue.getServer(player)));
                    }
                }
                continue;
            }
            lines.add(ServerUtil.replaceText(player, str));
        }

        return Utils.translate(lines);
    }

    @Override
    public ScoreboardStyle getBoardStyle(Player player) {
        return ScoreboardStyle.MODERN;
    }
}
