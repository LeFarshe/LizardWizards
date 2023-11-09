package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;

public class ConnectionInformation extends SentServerData {
    public final GameState gameState;

    public ConnectionInformation(GameState gameState) {
        super(SentDataType.ConnectionInformation);
        this.gameState = gameState;
    }

    @Override
    public void execute() {
        ClientConnectionHandler.CurrentHandler.setGameState(gameState);
        if (gameState == GameState.NotConnected && ClientConnectionHandler.CurrentHandler != null) {
            ClientConnectionHandler.CurrentHandler.closeConnection();
        }
    }
}
