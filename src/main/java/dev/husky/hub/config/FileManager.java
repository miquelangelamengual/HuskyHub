package dev.husky.hub.config;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.FileConfig;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;

/**
 * Created by Hulk
 * at 07/03/2022 7:03
 * Project: HuskyHub
 * Class: FileManager
 */

@Getter @Setter
public class FileManager {

    private FileConfig mainConfig;
    private FileConfig scoreboardConfig;
    private FileConfig tablistConfig;
    private FileConfig hotbarConfig;
    private FileConfig lobbySelectorConfig;
    private FileConfig serverSelectorConfig;
    private FileConfig messagesConfig;
    private FileConfig outfitConfig;

    public void init(Hub plugin) {
        this.mainConfig = new FileConfig(plugin, "settings.yml");
        this.messagesConfig = new FileConfig(plugin, "messages.yml");
        this.hotbarConfig = new FileConfig(plugin, "hotbar.yml");
        this.outfitConfig = new FileConfig(plugin, "outfits.yml");

        this.tablistConfig = new FileConfig(plugin, "provider/tablist.yml");
        this.scoreboardConfig = new FileConfig(plugin, "provider/scoreboard.yml");

        this.serverSelectorConfig = new FileConfig(plugin, "menus/server-selector");
        this.lobbySelectorConfig = new FileConfig(plugin, "menus/lobby-selector");
    }

    public void loadConfigs() {
        ScoreboardConfig.init();
        TablistConfig.init();
        MainConfig.init();
        MessagesConfig.init();
    }

}
