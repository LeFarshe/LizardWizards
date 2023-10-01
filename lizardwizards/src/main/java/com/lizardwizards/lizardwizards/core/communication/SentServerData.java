package com.lizardwizards.lizardwizards.core.communication;


public class SentServerData {
    public final Object payload;
    public final SentDataType dataType;

    public SentServerData(Object payload, SentDataType dataType) {
        this.payload = payload;
        this.dataType = dataType;
    }
}

