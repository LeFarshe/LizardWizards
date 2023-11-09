package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;

import java.util.HashMap;
import java.util.UUID;

public class RoomFactory {
    DefaultEnemyFactory enemyFactory = new DefaultEnemyFactory();
    public RoomInformation getRoom(RoomData room, int direction){
        HashMap<UUID, EntityWrapper> entities = new HashMap<>();
        if (room.id == RoomEnumerator.BasicRoom) {
            if (!room.cleared) {
                CreateEnemy(new Vector2(400, 400), entities);
            }

            CreateObstacle(new Vector2(200, 300), new Vector2(50,50), entities);
            CreateObstacle(new Vector2(600, 300), new Vector2(50,50), entities);

        }
        return new RoomInformation(entities, direction);
    }

    private void CreateEnemy(Vector2 position, HashMap<UUID, EntityWrapper> entities){
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
}
