package dev.husky.hub;

import dev.husky.hub.config.FileManager;
import dev.husky.hub.config.ScoreboardConfig;
import dev.husky.hub.hooks.PlaceholderAPIHook;
import dev.husky.hub.hooks.ScoreboardHook;
import dev.husky.hub.hooks.TablistHook;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.rank.RankManager;
import dev.husky.hub.utils.scoreboard.Scoreboard;
import es.hulk.tablist.Porc;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public class Hub extends JavaPlugin {

    @Getter public static Hub instance;

    private RankManager rankManager;
    private Scoreboard scoreboard;
    private Porc tablist;
    private FileManager fileManager;

    @Override
    public void onEnable() {
        instance = this;
        PlaceholderAPIHook.init();
        TablistHook.init();
        ScoreboardHook.init();
        fileManager.init(this);
    }

    @Override
    public void onDisable() {
        this.tablist.disable();
        this.scoreboard.getBoards().clear();
    }
}
