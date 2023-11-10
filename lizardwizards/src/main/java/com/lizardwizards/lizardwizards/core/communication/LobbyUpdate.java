package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.List;

public class LobbyUpdate extends SentServerData{
    public final List<EntityWrapper> readyPlayers;
    public final int maxPlayers;

    public LobbyUpdate(List<EntityWrapper> readyPlayers, int maxPlayers) {
        super(SentDataType.LobbyUpdate);
        this.readyPlayers = readyPlayers;
        this.maxPlayers = maxPlayers;
    }

    @Override
    public void execute() {
        var cch = ClientConnectionHandler.CurrentHandler;
        cch.connectedplayerList.clear(); // This is just cleaner
        cch.connectedplayerList.addAll(readyPlayers);
        if (maxPlayers == readyPlayers.size()) {
            cch.setGameState(GameState.InGame);
            Platform.runLater(() -> {
                ClientUtils.changeScene(cch.stage, 3);
                assert cch.player != null;
                ClientUtils.gameController.SetPlayer(cch.player);
            });
        }
    }
}
