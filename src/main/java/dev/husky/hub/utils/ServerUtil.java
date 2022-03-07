package dev.husky.hub.utils;

import dev.husky.hub.Hub;
import dev.husky.hub.config.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ServerUtil {

    private static final FileConfig config = Hub.getInstance().getFileManager().getMainConfig();
    private static final SimpleDateFormat timeDate = new SimpleDateFormat(config.getString("TIME.DATE"));
    private static final SimpleDateFormat timeHour = new SimpleDateFormat(config.getString("TIME.HOUR"));

    public static int getPing(Player player) {
        try {
            String a = Bukkit.getServer().getClass().getPackage().getName().substring(23);
            Class<?> b = Class.forName("org.bukkit.craftbukkit." + a + ".entity.CraftPlayer");
            Object c = b.getMethod("getHandle").invoke(player);
            return (int) c.getClass().getDeclaredField("ping").get(c);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String getDate() {
        timeDate.setTimeZone(TimeZone.getTimeZone(config.getString("TIME.ZONE")));
        return timeDate.format(new Date());
    }

    public static String getHour() {
        timeHour.setTimeZone(TimeZone.getTimeZone(config.getString("TIME.ZONE")));
        return timeHour.format(new Date());
    }

    public static String replaceText(Player player, String text) {
        return text
                .replace("%DISCORD%", MainConfig.DISCORD)
                .replace("%TWITTER%", MainConfig.TWITTER)
                .replace("%STORE%", MainConfig.STORE)
                .replace("%TEAMSPEAK%", MainConfig.TEAMSPEAK)
                .replace("%WEBSITE%", MainConfig.WEBSITE)
                .replace("%PLAYER%", player.getName())
                .replace("%RANK%", Hub.getInstance().getRankManager().getRank().getColor(player.getUniqueId()))
                .replace("%DATE%", getDate())
                .replace("%SLOTS%", Integer.toString(Bukkit.getServer().getMaxPlayers()))
                .replace("%PING%", Integer.toString(getPing(player)) )
                .replace("%HOUR%", getHour())
                .replace("%QUEUE_SERVER%", Hub.getInstance().getQueueManager().getSystem().getServer(player))
                .replace("%QUEUE_POSITION%", Integer.toString(Hub.getInstance().getQueueManager().getSystem().getPosition(player)))
                .replace("%QUEUE_SIZE%", Integer.toString(Hub.getInstance().getQueueManager().getSystem().getSize(player)));
    }

}
