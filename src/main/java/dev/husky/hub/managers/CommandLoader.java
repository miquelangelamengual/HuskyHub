package dev.husky.hub.managers;

import dev.husky.hub.commands.HubCommand;
import dev.husky.hub.commands.spawn.SetSpawnCommand;
import dev.husky.hub.commands.spawn.SpawnCommand;

/**
 * Created by Hulk
 * at 12/03/2022 16:18
 * Project: HuskyHub
 * Class: CommandLoader
 */

public class CommandLoader {

    public void loadCommands() {
        new HubCommand();
        new SpawnCommand();
        new SetSpawnCommand();
    }

}
