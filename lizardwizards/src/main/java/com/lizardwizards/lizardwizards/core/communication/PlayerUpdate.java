package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class PlayerUpdate extends SentServerData{
    public final EntityWrapper player;

    public PlayerUpdate(EntityWrapper player) {
        super(SentDataType.PlayerUpdate);
        this.player = player;
    }

    @Override
    public void execute() {
        var cch = ClientConnectionHandler.CurrentHandler;
        cch.player = player;
    }
}
