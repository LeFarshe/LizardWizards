package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.application.Platform;

import java.util.HashMap;
import java.util.UUID;

public class RoomInformation extends SentServerData{
    public static double xMax = 1600;
    public static double yMax = 900;
    public int direction = 0;
    public int enemyCount;
    public HashMap<UUID, EntityWrapper> entities;
    private HashMap<UUID, EntityWrapper> oldEntities;

    public RoomInformation(){
        super(SentDataType.Room);
        entities = new HashMap<>();
    }

    public RoomInformation(HashMap<UUID, EntityWrapper> entities, int direction, int enemyCount) {
        super(SentDataType.Room);
        this.entities = entities;
        this.direction = direction;
        this.enemyCount = enemyCount;
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
        addToHistory();
        var cch = ClientConnectionHandler.CurrentHandler;
        oldEntities = ClientUtils.gameController.getCopyOfEntities();
        Platform.runLater(()-> ClientUtils.gameController.initEntityList(this, cch.connectedplayerList));
    }

    @Override
    public void undo() {
        var cch = ClientConnectionHandler.CurrentHandler;
        entities = oldEntities;
        Platform.runLater(()-> ClientUtils.gameController.initEntityList(this, cch.connectedplayerList));
    }
}
