package dev.husky.hub.managers;

import dev.husky.hub.listeners.JoinListener;
import dev.husky.hub.listeners.QuitListener;

/**
 * Created by Hulk
 * at 12/03/2022 16:18
 * Project: HuskyHub
 * Class: ListenerLoader
 */

public class ListenerLoader {

    public void loadListeners() {
        new JoinListener();
        new QuitListener();
    }

}
