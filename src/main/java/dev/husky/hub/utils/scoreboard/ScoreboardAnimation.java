package dev.husky.hub.utils.scoreboard;

import dev.husky.hub.Hub;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hulk
 * at 21/02/2022 13:06
 * Project: Atlas
 * Class: ScoreboardAnimation
 */

public class ScoreboardAnimation {

    public static String title, footer;

    public static void init() {
        List<String> titles = Hub.getInstance().getScoreboardConfig().getStringList("ANIMATED_SCOREBOARD.TITLE.LINES");
        List<String> footers = Hub.getInstance().getScoreboardConfig().getStringList("ANIMATED_SCOREBOARD.FOOTER.LINES");

        title = titles.get(0);
        footer = footers.get(0);

        if (Hub.getInstance().getScoreboardConfig().getBoolean("ANIMATED_SCOREBOARD.TITLE.ENABLE")) {
            AtomicInteger atomicInteger = new AtomicInteger();

            Hub.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(Hub.getInstance(), () -> {
                if (atomicInteger.get() == titles.size()) atomicInteger.set(0);

                title = titles.get(atomicInteger.getAndIncrement());

            }, 0L, (long) (Hub.getInstance().getScoreboardConfig().getDouble("ANIMATED_SCOREBOARD.TITLE.TIME") * 20L));
        }

        if (Hub.getInstance().getScoreboardConfig().getBoolean("ANIMATED_SCOREBOARD.FOOTER.ENABLE")) {
            AtomicInteger atomicInteger = new AtomicInteger();

            Hub.getInstance().getServer().getScheduler().runTaskTimerAsynchronously(Hub.getInstance(), () -> {
                if (atomicInteger.get() == footers.size()) atomicInteger.set(0);

                footer = footers.get(atomicInteger.getAndIncrement());

            }, 0L, (long) (Hub.getInstance().getScoreboardConfig().getDouble("ANIMATED_SCOREBOARD.FOOTER.TIME") * 20L));
        }
    }

    public static String getScoreboardTitle() {
        return title;
    }

    public static String getScoreboardFooter() {
        return footer;
    }

}
