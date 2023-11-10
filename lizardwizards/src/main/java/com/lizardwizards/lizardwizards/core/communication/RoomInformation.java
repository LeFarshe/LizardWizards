package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.client.GameController;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.application.Platform;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RoomInformation extends SentServerData{
    public static double xMax = 1600;
    public static double yMax = 900;
    public int direction = 0;

    public HashMap<UUID, EntityWrapper> entities;

    public RoomInformation(){
        super(SentDataType.Room);
        entities = new HashMap<>();
    }

    public RoomInformation(HashMap<UUID, EntityWrapper> entities, int direction) {
        super(SentDataType.Room);
        this.entities = entities;
        this.direction = direction;
    }

    public Vector2 getPlayerPosition(){
        Vector2 position = switch (direction) {
            case 1 -> new Vector2(xMax / 2, 50);
            case 2 -> new Vector2(xMax - 50, yMax / 2);
            case 3 -> new Vector2(xMax / 2, yMax - 50);
            case 4 -> new Vector2(50, yMax / 2);
            default -> new Vector2(xMax / 2, yMax / 2);
        };
        return position;
    }

    @Override
    public void execute() {
        var cch = ClientConnectionHandler.CurrentHandler;
        Platform.runLater(()-> ClientUtils.gameController.initEntityList(this, cch.connectedplayerList));
    }
}
