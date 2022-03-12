package dev.husky.hub.commands.spawn;

import dev.husky.hub.Hub;
import dev.husky.hub.utils.Utils;
import dev.husky.hub.utils.command.BaseCommand;
import dev.husky.hub.utils.command.Command;
import dev.husky.hub.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 12/03/2022 16:13
 * Project: HuskyHub
 * Class: SpawnCommand
 */

public class SpawnCommand extends BaseCommand {

    @Command(name = "spawn")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        Hub.getInstance().getSpawnManager().teleportPlayer(player);
        player.sendMessage(Utils.translate("Teleported to Spawn"));
    }
}
