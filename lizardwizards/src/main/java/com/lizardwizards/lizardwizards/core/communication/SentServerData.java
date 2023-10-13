package com.lizardwizards.lizardwizards.core.communication;


import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.GameController;
import com.lizardwizards.lizardwizards.client.ui.GameHUD;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.List;

public class SentServerData implements Serializable {
    public final Object payload;
    public final SentDataType dataType;

    public SentServerData(Object payload, SentDataType dataType) {
        this.payload = payload;
        this.dataType = dataType;
    }

    public void handleSyncPacket(GameController gameController) {
        Platform.runLater(() -> {
            GameHUD.getInstance().setScore(((SyncPacket)payload).currentScore);
            gameController.updateEntityList((SyncPacket) payload);
        });
    }

    public Boolean handleConnectionInformation() {
        return (Boolean) payload; // Might want to change this to be a little bit more in depth
    }

    public LobbyUpdate handleLobbyUpdate() {
        return (LobbyUpdate) payload;
    }
    public void handleRoomLoading(GameController gameController, List<EntityWrapper> players) {
        RoomInformation room = (RoomInformation) payload;
        Platform.runLater(()->gameController.initEntityList(room, players));


    }
}

