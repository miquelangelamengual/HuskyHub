package dev.husky.hub.menus.server.menu;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import dev.husky.hub.Hub;
import dev.husky.hub.menus.server.Server;
import dev.husky.hub.utils.Utils;
import dev.husky.hub.utils.menu.Button;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class ServerButton extends Button {

    private Server server;

    @Override
    public ItemStack getButtonItem(Player p0) {
        return server.createItem();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {
        if (server.isQueue()) {
            if (!Hub.getInstance().getQueueManager().getQueue().equals("None")) {
                Hub.getInstance().getQueueManager().getSystem().sendToServer(player, server.getServer());
            } else {
                player.sendMessage(Utils.translate("&cNo Queue Implementation"));
            }
        }

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(player.getName());
        out.writeUTF(server.getServer());
        player.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
    }
}
