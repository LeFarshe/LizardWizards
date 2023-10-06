package com.lizardwizards.lizardwizards.core.communication;


import com.lizardwizards.lizardwizards.client.GameController;

public class SentServerData {
    public final Object payload;
    public final SentDataType dataType;

    public SentServerData(Object payload, SentDataType dataType) {
        this.payload = payload;
        this.dataType = dataType;
    }

    public void handleSyncPacket(GameController gameController) {
        gameController.updateEntityList((SyncPacket) payload);
    }

    public Boolean handleConnectionInformation() {
        return (Boolean) payload; // Might want to change this to be a little bit more in depth
    }
}

