package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.gameplay.Player;

import java.util.ArrayList;
import java.util.List;

public class Session {
    public int playersConnected;
    public int maxPlayers;
    private final List<Player> players;

    public Session(int maxPlayers) {
        playersConnected = 0;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>(maxPlayers);
    }

    public Session() {
        this(2);
    }

    public Session addPlayer(Player player) {
        players.add(player);
        playersConnected ++;
        return this;
    }

    public Session removePlayer(Player player) throws Exception {
        int index = players.indexOf(player);
        if (index == -1) {
            throw new Exception("Player not found");
        }
        return removePlayer(index);
    }

    public Session removePlayer(int index) {
        players.remove(index);
        playersConnected--;
        return this;
    }

    public boolean acceptingConnections() {
        return playersConnected < maxPlayers;
    }
}
