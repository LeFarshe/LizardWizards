package com.lizardwizards.lizardwizards.core.communication;


import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.GameController;
import com.lizardwizards.lizardwizards.client.ui.GameHUD;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.List;

public abstract class SentServerData implements Serializable {
    public final SentDataType dataType;

    public SentServerData(SentDataType dataType) {
        this.dataType = dataType;
    }

    public abstract void execute();
}

