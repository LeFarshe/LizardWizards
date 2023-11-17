package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.communication.LobbyUpdate;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Session {
    public int playersConnected;
    public int maxPlayers;
    final List<PlayerHandler> players;
    private GameState gameState;

    public Session(int maxPlayers) {
        gameState = GameState.InLobby;
        playersConnected = 0;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>(maxPlayers);
    }

    public Session() {
        this(1);
    }

    public void addPlayer(PlayerHandler player) {
        players.add(player);
        playersConnected ++;
    }

    public boolean acceptingConnections() {
        return playersConnected < maxPlayers;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void sendToPlayers(SentServerData sentServerData) {
        try {
            for (PlayerHandler x : players) {
                x.sendToPlayer(sentServerData);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLobby() {
        sendToPlayers(new LobbyUpdate(
                        players.stream().filter(PlayerHandler::isReady).map(PlayerHandler::getPlayer).toList(),
                        maxPlayers));
    }

    public boolean startGame() {
        if (playersConnected == maxPlayers && players.stream().allMatch(PlayerHandler::isReady)) {
            // This assumes that the game will start as soon as the lobby is full and every player is ready
            gameState = GameState.InGame;
            players.forEach(PlayerHandler::handleMainGame);
            return true;
        }
        return false;
    }
}
