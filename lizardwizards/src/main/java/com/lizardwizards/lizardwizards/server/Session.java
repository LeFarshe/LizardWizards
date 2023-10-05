package com.lizardwizards.lizardwizards.server;

import java.util.ArrayList;
import java.util.List;

public class Session {
    public int playersConnected;
    public int maxPlayers;
    private final List<PlayerHandler> players;
    private GameState gameState;

    public Session(int maxPlayers) {
        gameState = GameState.Lobby;
        playersConnected = 0;
        this.maxPlayers = maxPlayers;
        players = new ArrayList<>(maxPlayers);
    }

    public Session() {
        this(2);
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

    public boolean startGame() {
        if (playersConnected == maxPlayers && players.stream().allMatch(PlayerHandler::isReady)) {
            // This assumes that the game will start as soon as the lobby is full and every player is ready
            gameState = GameState.MainGame;
            players.forEach(PlayerHandler::handleMainGame);
            return true;
        }
        return false;
    }
}
