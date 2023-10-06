package com.lizardwizards.lizardwizards.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class GameController {
    HashMap<UUID, EntityWrapper> entities = new HashMap<>();
    EntityWrapper currentPlayer;
    PlayerControls playerControls = new PlayerControls();
    Pane root;
    GameTimer currentTimer;

    GameController(Pane root)
    {
        this.root = root;
        root.setPrefSize(800,600);
    }
    public void start(SyncPacket syncPacket) {
        // CreateObstacle(new Vector2(200, 300));
        // CreateObstacle(new Vector2(600, 300));
        // CreateEnemy(new Vector2(400, 400));
        currentTimer = new GameTimer(syncPacket.serverTime);
        updateEntityList(syncPacket);
    }

    public void updateEntityList(SyncPacket syncPacket) {
        currentTimer.stop();

        syncPacket.destroyedEntities.forEach(entity -> {
            root.getChildren().remove(entity.sprite);
        });
        syncPacket.createdEntities.values().forEach(entity -> {
            root.getChildren().add(entity.sprite);
            entities.put(entity.entity.uuid, entity);
        });
        currentTimer.syncWithServerTimer(syncPacket.createdEntities);
        entities.forEach((uuid, entity) -> {
            entity.update(syncPacket.entities.get(uuid));
        });

        currentTimer.start();
    }

    private class GameTimer extends AnimationTimer {
        long prevTime = -1;
        long serverClientDiff;

        void syncWithServerTimer(HashMap<Long, EntityWrapper> createdEntities) {
            if (prevTime >= 0) {
                createdEntities.forEach((serverDelta, entity) -> {
                    long delta = serverDelta - serverClientDiff;
                    entity.MoveByDelta(delta, entities);
                    if (entity.entity.IsDestroyed()) {
                        root.getChildren().remove(entity.sprite);
                        entities.remove(entity.entity.uuid);
                    }

                });
            }
        }

        GameTimer(long serverTime) {
            serverClientDiff = serverTime;
        }

        @Override
        public void handle(long now){
            double timeElapsed;
            List<Projectile> newProjectiles = new ArrayList<>();
            if (prevTime >= 0)
            {
                Vector2 newMovement = playerControls.HandleMovement();
                if (newMovement != null) { ((Player)currentPlayer.entity).StartMoving(newMovement);}

                Vector2 newShooting = playerControls.HandleShooting();
                if (newShooting != null) { ((Player)currentPlayer.entity).StartShooting(newShooting); }

                timeElapsed = (now-prevTime)/1000000000.0;

                ProjectileHandling(((Player)currentPlayer.entity).Shoot(timeElapsed));

                entities.forEach((uuid, entity) -> {
                    entity.MoveByDelta(timeElapsed, entities);
                    if (entity.entity.IsDestroyed()) {
                        root.getChildren().remove(entity.sprite);
                        entities.remove(uuid);
                    }

                });
            }
            else{
                serverClientDiff -= now;
            }
            prevTime = now;
        }

        private void ProjectileHandling(List<Projectile> newProjectiles)
        {
            if (newProjectiles != null) {
                for (Projectile projectile : newProjectiles) {
                    EntitySprite sprite = projectile.GetSprite();
                    root.getChildren().add(sprite);

                    EntityWrapper newProjectile = new EntityWrapper(projectile, sprite, projectile.GetCollider());
                    entities.put(projectile.uuid, newProjectile);
                }
            }

        }
    }

    //Temp
    public void SetCurrentPlayer()
    {
        Player player = new Player(new Vector2(400,300), 100);
        Collider collider = Collider.NewRectangle(new Vector2(400, 300), 20, 20, 0);
        player.weapons.add(new Gun());
        EntitySprite playerSprite = new EntitySprite(new Vector2(0,0), new Vector2(20,20));
        currentPlayer = new EntityWrapper(player, playerSprite, collider);
        entities.put(player.uuid, currentPlayer);
        root.getChildren().add(playerSprite);
    }

    public void SetPlayer(EntityWrapper player)
    {
        currentPlayer = player;
        entities.put(player.entity.uuid, currentPlayer);
        root.getChildren().add(player.sprite);
    }
}
