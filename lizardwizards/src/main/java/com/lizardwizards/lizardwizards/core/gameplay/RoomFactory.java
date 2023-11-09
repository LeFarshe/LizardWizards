package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;

import java.util.HashMap;
import java.util.UUID;

public class RoomFactory {
    public RoomInformation getRoom(Level currentLevel, IEnemyFactory enemyFactory){
        HashMap<UUID, EntityWrapper> entities = new HashMap<>();
        CreateWalls(entities);
        CreateDoors(entities, currentLevel.getDoors());
        if (currentLevel.getCurrentRoom().id == RoomEnumerator.BasicRoom) {
            if (!currentLevel.getCurrentRoom().cleared) {
                CreateEnemy(new Vector2(400, 400), entities, enemyFactory);
            }

            CreateObstacle(new Vector2(200, 300), new Vector2(50,50), entities);
            CreateObstacle(new Vector2(600, 300), new Vector2(50,50), entities);

        }
        return new RoomInformation(entities, currentLevel.enteredDirection);
    }

    private void CreateEnemy(Vector2 position, HashMap<UUID, EntityWrapper> entities, IEnemyFactory enemyFactory){
        IEnemy enemy = enemyFactory.createEnemy(position, 100);
        EntitySprite sprite = new EntitySprite(position, new Vector2(15, 15));
        Collider collider = Collider.NewRectangle(position, 15, 15, CollisionLayer.Enemy);
        EntityWrapper newEntity = new EntityWrapper((Entity)enemy, sprite, collider);
        entities.put(((Entity) enemy).uuid, newEntity);
    }

    private void CreateObstacle(Vector2 position, Vector2 size, HashMap<UUID, EntityWrapper> entities){
        Obstacle obstacle  = new Obstacle(position);
        EntitySprite sprite = new EntitySprite(position, new Vector2(size.x, size.y));
        Collider collider = Collider.NewRectangle(position, size.x, size.y, CollisionLayer.Obstacle);
        EntityWrapper newObstacle = new EntityWrapper(obstacle, sprite, collider);
        entities.put(obstacle.uuid, newObstacle);
    }

    private void CreateDoors(HashMap<UUID, EntityWrapper> entities, boolean[] doors){
        if (doors[0]) {
            CreateObstacle(new Vector2(RoomInformation.xMax / 2, 0), new Vector2(50, 10), entities);
        }
        if (doors[1]) {
            CreateObstacle(new Vector2(RoomInformation.xMax, RoomInformation.yMax / 2), new Vector2(10, 50), entities);
        }
        if (doors[2]) {
            CreateObstacle(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax), new Vector2(50, 10), entities);
        }
        if (doors[3]) {
            CreateObstacle(new Vector2(0, RoomInformation.yMax / 2), new Vector2(10, 50), entities);
        }
    }

    private void CreateWalls(HashMap<UUID, EntityWrapper> entities){
        CreateObstacle(new Vector2(RoomInformation.xMax / 2, -10), new Vector2(RoomInformation.xMax, 20), entities);
        CreateObstacle(new Vector2(RoomInformation.xMax + 10, RoomInformation.yMax / 2), new Vector2(20, RoomInformation.yMax), entities);
        CreateObstacle(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax + 10), new Vector2(RoomInformation.xMax, 20), entities);
        CreateObstacle(new Vector2(-10, RoomInformation.yMax / 2), new Vector2(20, RoomInformation.yMax), entities);
    }
}
