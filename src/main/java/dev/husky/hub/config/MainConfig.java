package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MainConfig {

    private final FileConfig config = Hub.getInstance().getFileManager().getMainConfig();

    public String DISCORD;
    public String STORE;
    public String WEBSITE;
    public String TEAMSPEAK;
    public String TWITTER;

    public boolean JOIN_MESSAGE;
    public List<String> JOIN_MESSAGE_LIST;

    public boolean VIP_JOIN;
    public String VIP_PERMISSION;
    public String VIP_JOIN_MESSAGE;
    public String VIP_LEAVE_MESSAGE;

    public void init() {
        DISCORD = config.getString("SOCIAL.DISCORD");
        STORE = config.getString("SOCIAL.STORE");
        WEBSITE = config.getString("SOCIAL.WEBSITE");
        TEAMSPEAK = config.getString("SOCIAL.TEAMSPEAK");
        TWITTER = config.getString("SOCIAL.TWITTER");

        JOIN_MESSAGE = config.getBoolean("JOIN_MESSAGE.ENABLE");
        JOIN_MESSAGE_LIST = config.getStringList("JOIN_MESSAGE.MESSAGE");

        VIP_JOIN = config.getBoolean("VIP_JOIN.ENABLE");
        VIP_PERMISSION = config.getString("VIP_JOIN.PERMISSION");
        VIP_JOIN_MESSAGE = config.getString("VIP_JOIN.JOIN");
        VIP_LEAVE_MESSAGE = config.getString("VIP_JOIN.LEAVE");
    }
}
