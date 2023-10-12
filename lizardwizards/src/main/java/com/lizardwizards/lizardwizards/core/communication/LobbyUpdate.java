package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

import java.io.Serializable;
import java.util.List;

public class LobbyUpdate implements Serializable {
    public final List<EntityWrapper> readyPlayers;
    public final int maxPlayers;

    public LobbyUpdate(List<EntityWrapper> readyPlayers, int maxPlayers) {
        this.readyPlayers = readyPlayers;
        this.maxPlayers = maxPlayers;
    }
}
