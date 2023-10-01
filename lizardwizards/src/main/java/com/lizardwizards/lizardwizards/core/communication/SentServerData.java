package com.lizardwizards.lizardwizards.core.communication;


public class SentServerData {
    public final Object payload;
    public final SentDataType dataType;

    public SentServerData(Object payload, SentDataType dataType) {
        this.payload = payload;
        this.dataType = dataType;
    }

    public Object handleSyncPacket() {
        return payload; // TODO: change this (these a github issue for this dw)
    }

    public Boolean handleConnectionInformation() {
        return (Boolean) payload; // Might want to change this to be a little bit more in depth
    }
}

