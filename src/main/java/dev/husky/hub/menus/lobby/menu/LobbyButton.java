package dev.husky.hub.menus.lobby.menu;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import dev.husky.hub.Hub;
import dev.husky.hub.menus.lobby.Lobby;
import dev.husky.hub.utils.menu.Button;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

@Getter
public class LobbyButton extends Button {

    private Lobby lobby;

    public LobbyButton(Lobby lobby) {
        this.lobby = lobby;
    }

    @Override
    public ItemStack getButtonItem(Player p0) {
        return lobby.createItem();
    }

    @Override
    public void clicked(Player player, int slot, ClickType clickType, int hotbarButton) {

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("ConnectOther");
        out.writeUTF(player.getName());
        out.writeUTF(lobby.getLobby());
        player.sendPluginMessage(Hub.getInstance(), "BungeeCord", out.toByteArray());
    }
}
