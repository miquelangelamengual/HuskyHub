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
 * Class: SetSpawnCommand
 */

public class SetSpawnCommand extends BaseCommand {

    @Command(name = "setspawn", permission = "ghub.command.setspawn")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();

        Hub.getInstance().getSpawnManager().setSpawnLocation(player.getLocation());
        player.sendMessage(Utils.translate("Spawn setted to "
                + player.getLocation().getBlockX() + " "
                + player.getLocation().getBlockY() + " "
                + player.getLocation().getBlockZ() + " "
                + player.getLocation().getWorld().getName() + "."));
    }
}
