package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessagesConfig {

    private final FileConfig config = Hub.getInstance().getFileManager().getMessagesConfig();

    public String VISIBILITY_OFF;
    public String VISIBILITY_ON;

    public void init() {
        VISIBILITY_OFF = config.getString("VISIBILITY.OFF");
        VISIBILITY_ON = config.getString("VISIBILITY.ON");
    }

}
