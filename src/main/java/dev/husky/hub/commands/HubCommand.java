package dev.husky.hub.commands;

import dev.husky.hub.Hub;
import dev.husky.hub.config.FileManager;
import dev.husky.hub.utils.command.BaseCommand;
import dev.husky.hub.utils.command.Command;
import dev.husky.hub.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Hulk
 * at 06/03/2022 20:32
 * Project: HuskyHub
 * Class: HubCommand
 */

public class HubCommand extends BaseCommand {

    private final FileManager fileManager = Hub.getInstance().getFileManager();

    @Command(name = "ghub", aliases = "goldenhub")

    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            player.sendMessage("GoldenHub");
            player.sendMessage("");
            player.sendMessage("/ghub reload - reload config");
            player.sendMessage("/ghub info - see plugin info");
            player.sendMessage("");
        }

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission("ghub.command.reload")) {
                    fileManager.reloadConfigs();
                    player.sendMessage("config reloaded");
                }
            }
            if (args[0].equalsIgnoreCase("info")) {
                player.sendMessage("GoldenHub - " + Hub.getInstance().getDescription().getVersion());
                player.sendMessage("");
                player.sendMessage("Authors: " + Hub.getInstance().getDescription().getAuthors());
                player.sendMessage("Version: " + Hub.getInstance().getDescription().getVersion());
                player.sendMessage("Support: https://discord.gg/jnQHV3QkgA");
            }
        }
    }
}
