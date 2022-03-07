package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MainConfig {

    private final FileConfig config = Hub.getInstance().getFileManager().getMainConfig();

    public String DISCORD;
    public String STORE;
    public String WEBSITE;
    public String TEAMSPEAK;
    public String TWITTER;

    public void init() {
        DISCORD = config.getString("SOCIAL.DISCORD");
        STORE = config.getString("SOCIAL.STORE");
        WEBSITE = config.getString("SOCIAL.WEBSITE");
        TEAMSPEAK = config.getString("SOCIAL.TEAMSPEAK");
        TWITTER = config.getString("SOCIAL.TWITTER");


    }
}
