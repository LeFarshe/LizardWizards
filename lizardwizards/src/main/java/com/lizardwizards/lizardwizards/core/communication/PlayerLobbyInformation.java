package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.gameplay.PlayerClass;

import java.io.Serializable;

public class PlayerLobbyInformation implements Serializable {
    public final boolean isReady;
    public final PlayerClass chosenClass;

    public PlayerLobbyInformation(boolean isReady, PlayerClass chosenClass) {
        this.isReady = isReady;
        this.chosenClass = chosenClass;
    }
}
