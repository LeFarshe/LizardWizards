package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.Obstacle;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.DefaultEnemyFactory;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.IEnemy;

import java.util.HashMap;
import java.util.UUID;

public class RoomFactory {
    int enemyCount = 0;
    public RoomInformation getRoom(Level currentLevel, DefaultEnemyFactory enemyFactory){
        enemyCount = 0;
        HashMap<UUID, EntityWrapper> entities = new HashMap<>();
        CreateWalls(entities);
        CreateDoors(entities, currentLevel.getDoors());
        if (currentLevel.getCurrentRoom().id == RoomEnumerator.BasicRoom) {
            if (!currentLevel.getCurrentRoom().cleared) {
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
            }

            AddEntity(CreateObstacle(new Vector2(200, 300), new Vector2(50,50)), entities);
            AddEntity(CreateObstacle(new Vector2(600, 300), new Vector2(50,50)), entities);

        }
        else if (currentLevel.getCurrentRoom().id == RoomEnumerator.BasicRoom2){
            if (!currentLevel.getCurrentRoom().cleared) {
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
                AddEntity(CreateEnemy(new Vector2(400, 400), enemyFactory), entities);
            }

            AddEntity(CreateObstacle(new Vector2(200, 300), new Vector2(50,50)), entities);
            AddEntity(CreateObstacle(new Vector2(1000, 300), new Vector2(50,50)), entities);
        }
        return new RoomInformation(entities, currentLevel.enteredDirection, enemyCount);
    }



    private EntityWrapper CreateEnemy(Vector2 position, DefaultEnemyFactory enemyFactory){
        enemyCount++;
        IEnemy enemy = enemyFactory.createEnemy(position, 5);
        RectangleSprite sprite = new RectangleSprite(position, new Vector2(15, 15));
        Collider collider = Collider.NewRectangle(position, 15, 15, CollisionLayer.Enemy);
        EntityWrapper newEntity = new EntityWrapper((Entity)enemy, sprite, collider);
        newEntity.SetColor(new SpriteColor(1, 0, 0));
        return newEntity;
    }

    private EntityWrapper CreateObstacle(Vector2 position, Vector2 size){
        Obstacle obstacle  = new Obstacle(position);
        RectangleSprite sprite = new RectangleSprite(position, new Vector2(size.x, size.y));
        Collider collider = Collider.NewRectangle(position, size.x, size.y, CollisionLayer.Obstacle);
        return new EntityWrapper(obstacle, sprite, collider);
    }

    private void AddEntity(EntityWrapper entity, HashMap<UUID, EntityWrapper> entities){
        entities.put(entity.entity.uuid, entity);
    }

    private void CreateDoors(HashMap<UUID, EntityWrapper> entities, boolean[] doors){
        EntityWrapper doorVertical = CreateObstacle(new Vector2(RoomInformation.xMax / 2, 0), new Vector2(50, 10));
        EntityWrapper doorHorizontal = CreateObstacle(new Vector2(RoomInformation.xMax, RoomInformation.yMax / 2), new Vector2(10, 50));
        if (doors[0]) {
            AddEntity(doorVertical, entities);
        }
        if (doors[1]) {
            AddEntity(doorHorizontal, entities);
        }
        if (doors[2]) {
            EntityWrapper verticalClone = doorVertical.clone();
            verticalClone.SetPosition(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax));
            AddEntity(verticalClone, entities);
        }
        if (doors[3]) {
            EntityWrapper horizontalClone = doorHorizontal.clone();
            horizontalClone.SetPosition(new Vector2(0, RoomInformation.yMax / 2));
            AddEntity(horizontalClone, entities);
        }
    }

    private void CreateWalls(HashMap<UUID, EntityWrapper> entities){
        EntityWrapper wallVertical = CreateObstacle(new Vector2(RoomInformation.xMax / 2, -10), new Vector2(RoomInformation.xMax, 20));
        wallVertical.SetColor(new SpriteColor(0.2, 0.2, 0.2));
        AddEntity(wallVertical, entities);

        wallVertical = wallVertical.clone();
        wallVertical.SetPosition(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax + 10));
        AddEntity(wallVertical, entities);


        EntityWrapper wallHorizontal = CreateObstacle(new Vector2(RoomInformation.xMax + 10, RoomInformation.yMax / 2), new Vector2(20, RoomInformation.yMax));
        wallHorizontal.SetColor(new SpriteColor(0.2, 0.2, 0.2));
        AddEntity(wallHorizontal, entities);

        wallHorizontal = wallHorizontal.clone();
        wallHorizontal.SetPosition(new Vector2(-10, RoomInformation.yMax / 2));
        AddEntity(wallHorizontal, entities);
    }
}
