package dev.husky.hub;

import dev.husky.hub.config.FileManager;
import dev.husky.hub.config.ScoreboardConfig;
import dev.husky.hub.hooks.PlaceholderAPIHook;
import dev.husky.hub.hooks.ScoreboardHook;
import dev.husky.hub.hooks.TablistHook;
import dev.husky.hub.hotbar.Hotbar;
import dev.husky.hub.queue.QueueManager;
import dev.husky.hub.utils.FileConfig;
import dev.husky.hub.utils.command.CommandManager;
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
    private QueueManager queueManager;
    private FileManager fileManager;
    private Hotbar hotbar;
    private CommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        PlaceholderAPIHook.init();
        TablistHook.init();
        ScoreboardHook.init();
        fileManager.init(this);
        this.loadManagers();
    }

    private void loadManagers() {
        this.rankManager = new RankManager();
        this.queueManager = new QueueManager();
        this.hotbar = new Hotbar();
        this.commandManager = new CommandManager(this);
    }

    @Override
    public void onDisable() {
        ScoreboardHook.getScoreboard().getBoards().clear();
        TablistHook.getTablist().disable();
    }
}
