package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RoomInformation implements Serializable {
    public static double xMax = 1600;
    public static double yMax = 900;
    public int direction = 0;

    public HashMap<UUID, EntityWrapper> entities;

    public RoomInformation(){
        entities = new HashMap<>();
    }


    public RoomInformation(HashMap<UUID, EntityWrapper> entities, int direction) {
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
}
