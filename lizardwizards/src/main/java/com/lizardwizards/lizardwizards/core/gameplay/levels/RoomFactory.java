package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.Obstacle;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemies;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;
import com.lizardwizards.lizardwizards.core.gameplay.items.ItemHolder;

import java.util.HashMap;
import java.util.UUID;

public class RoomFactory {
    int enemyCount = 0;
    public RoomInformation getRoom(Level currentLevel){
        RoomData currentRoom = currentLevel.getCurrentRoom();
        enemyCount = 0;
        HashMap<UUID, EntityWrapper> entities = new HashMap<>();
        CreateWalls(entities);
        CreateDoors(entities, currentLevel.getDoors());
        if (currentRoom.isBossRoom()){
            CreateTrapDoor(entities);
        }
        switch (currentRoom.id) {
            case BasicRoom -> {
                if (!currentRoom.cleared) {
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.Fly), entities);
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.Fly), entities);
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.Fly), entities);
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.Fly), entities);
                }
                AddEntity(CreateObstacle(new Vector2(200, 300), new Vector2(50, 50)), entities);
                AddEntity(CreateObstacle(new Vector2(600, 300), new Vector2(50, 50)), entities);
            }
            case BasicRoom2 -> {
                if (!currentRoom.cleared) {
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.Fly), entities);
                    AddEntity(CreateEnemy(new Vector2(400, 400), Enemies.FlyWithGun), entities);
                }
                AddEntity(CreateObstacle(new Vector2(200, 300), new Vector2(50, 50)), entities);
                AddEntity(CreateObstacle(new Vector2(1000, 300), new Vector2(50, 50)), entities);
            }
            case BossRoom -> {
                if (!currentRoom.cleared) {
                    AddEntity(CreateEnemy(new Vector2(900, 500), Enemies.Cicada), entities);
                }
            }
        }
        for (ExistingItem item: currentRoom.itemList){
            AddEntity(CreateItem(item.position, item.item), entities);
        }
        return new RoomInformation(entities, currentLevel.enteredDirection, enemyCount);
    }

    private EntityWrapper CreateEnemy(Vector2 position, Enemies enemy){
        enemyCount++;
        return enemy.getEntityWrapper(position);
    }

    private EntityWrapper CreateObstacle(Vector2 position, Vector2 size){
        Obstacle obstacle  = new Obstacle(position);
        RectangleSprite sprite = new RectangleSprite(new Vector2(size.x, size.y));
        Collider collider = Collider.NewRectangle(position, size.x, size.y, CollisionLayer.Obstacle);
        return new EntityWrapper(obstacle, sprite, collider);
    }

    private EntityWrapper CreateItem(Vector2 position, Item item){
        ItemHolder itemHolder = new ItemHolder(position, item);
        EntitySprite sprite = item.getSprite();
        Collider collider = Collider.NewRectangle(position, item.getSize().x, item.getSize().y, CollisionLayer.Item);
        return new EntityWrapper(itemHolder, sprite, collider);
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

    private void CreateTrapDoor(HashMap<UUID, EntityWrapper> entities){
        Entity trapDoor = new Obstacle(new Vector2(RoomInformation.xMax / 2,RoomInformation.yMax / 5));
        RectangleSprite trapDoorSprite = new RectangleSprite(new Vector2(0,0), new Vector2(32,32), new SpriteColor(2.0/3, 1.0/6, 1.0/6));
        AddEntity(new EntityWrapper(trapDoor, trapDoorSprite, null), entities);
    }
}
