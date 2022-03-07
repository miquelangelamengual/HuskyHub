package dev.husky.hub;

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

    private FileConfig scoreboardConfig;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        this.tablist.disable();
        this.scoreboard.getBoards().clear();
    }
}
