package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class RoomInformation {
    public final HashMap<UUID, EntityWrapper> entities;
    public final List<Vector2> playerStartPositions;


    public RoomInformation(HashMap<UUID, EntityWrapper> entities, List<Vector2> playerStartPositions) {
        this.entities = entities;
        this.playerStartPositions = playerStartPositions;
    }

    public static RoomInformation getTestRoom(){
        HashMap<UUID, EntityWrapper> entities = new HashMap<>();
        LinkedList<Vector2> playerStartPositions = new LinkedList<>();
        playerStartPositions.add(new Vector2(400, 300));
        playerStartPositions.add(new Vector2(800, 300));

        CreateObstacle(new Vector2(200, 300), entities);
        CreateObstacle(new Vector2(600, 300), entities);
        CreateEnemy(new Vector2(400, 400), entities);

        return new RoomInformation(entities, playerStartPositions);
    }

    public static void CreateEnemy(Vector2 position, HashMap<UUID, EntityWrapper> entities){
    Enemy enemy = new Enemy(position, 100);
    EntitySprite sprite = new EntitySprite(position, new Vector2(15, 15));
    Collider collider = Collider.NewRectangle(position, 15, 15, 2);
    EntityWrapper newEntity = new EntityWrapper(enemy, sprite, collider);
    entities.put(enemy.uuid, newEntity);
    }

    public static void CreateObstacle(Vector2 position, HashMap<UUID, EntityWrapper> entities){
        Obstacle obstacle  = new Obstacle(position);
        EntitySprite sprite = new EntitySprite(position, new Vector2(50, 50));
        Collider collider = Collider.NewRectangle(position, 50, 50, 3);
        EntityWrapper newObstacle = new EntityWrapper(obstacle, sprite, collider);
        entities.put(obstacle.uuid, newObstacle);
    }
}
