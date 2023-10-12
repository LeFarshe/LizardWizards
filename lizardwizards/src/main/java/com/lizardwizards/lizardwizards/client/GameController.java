package com.lizardwizards.lizardwizards.client;

import java.util.*;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.communication.SentPlayerData;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

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
        System.out.println(currentPlayer.entity.uuid);
        currentTimer = new GameTimer(syncPacket.serverTime);
        currentTimer.start();
    }

    public void initEntityList(RoomInformation room, List<EntityWrapper> players) {
        entities.forEach((uuid, entity) -> root.getChildren().remove(entity.sprite));
        entities.clear();
        players.forEach(player -> entities.put(player.entity.uuid, player));
        entities.putAll(room.entities);

        players.sort(Comparator.comparing(a -> a.entity.uuid));
        for (int i = 0; i < players.size(); i++) {
            players.get(i).SetPosition(room.playerStartPositions.get(i));
        }

        entities.forEach((uuid, entity) -> {
            entity.sprite.ResetSize(); // TODO remove
            root.getChildren().add(entity.sprite);});
    }

    public void updateEntityList(SyncPacket syncPacket) {
        currentTimer.stop();
        syncPacket.createdEntities.forEach(pair -> {
            var entity = pair.getValue();
            entity.sprite.ResetSize(); // TODO remove
            root.getChildren().add(entity.sprite);
            entities.put(entity.entity.uuid, entity);
        });
        currentTimer.syncWithServerTimer(syncPacket, syncPacket.createdEntities);
        syncPacket.destroyedEntities.forEach((entity) -> {
            EntityWrapper canonEntity = entities.get(entity.entity.uuid);
            root.getChildren().remove(canonEntity.sprite);
            entities.remove(canonEntity.entity.uuid);
        });

        currentTimer.start();
    }

    private class GameTimer extends AnimationTimer {
        long prevTime = -1;
        long serverClientDiff;

        synchronized void syncWithServerTimer(SyncPacket syncPacket, List<Pair<Long, EntityWrapper>> createdEntities) {
            createdEntities.forEach(pair -> {
                var entity = pair.getValue();
                double delta = (pair.getKey() / 1000.0 - serverClientDiff);
                root.getChildren().add(entity.sprite); // TODO this spams errors like crazy, but if this isn't here the projectiles don't shoot
                // I have no idea why but this is the case
                // I will never use JavaFX willingly ever again
                entity.MoveByDelta(delta, entities);
            });

            for (Map.Entry<UUID, EntityWrapper> entry : entities.entrySet()) {
                UUID uuid = entry.getKey();
                EntityWrapper entity = entry.getValue();
                if (syncPacket.entities.containsKey(uuid)) // this is shit, but it's also late
                {
                    entity.update(syncPacket.entities.get(uuid));
                }
            }
        }

        GameTimer(long serverTime) {
            serverClientDiff = serverTime;
        }

        @Override
        public synchronized void handle(long now){
            double timeElapsed;
            if (prevTime >= 0)
            {
                Vector2 newMovement = playerControls.HandleMovement();
                if (newMovement != null) {
                    ((Player)currentPlayer.entity).StartMoving(newMovement);
                }

                Vector2 newShooting = playerControls.HandleShooting();
                if (newShooting != null) {
                    ((Player)currentPlayer.entity).StartShooting(newShooting);
                }

                ClientConnectionHandler.CurrentHandler.sendUpdate(currentPlayer.entity.GetPosition() ,newMovement, newShooting);

                timeElapsed = (now-prevTime)/1000000000.0;

                // ProjectileHandling(((Player)currentPlayer.entity).Shoot(timeElapsed), CollisionLayer.PlayerProjectile);

                entities.forEach((uuid, entity) -> { // this foreach loop updates the screen somehow
                    entity.MoveByDelta(timeElapsed, entities);
                    //if (entity.entity.IsDestroyed()) {
                        //root.getChildren().remove(entity.sprite);
                        //entities.remove(uuid);
                    //}
                });
            }
            else{
                serverClientDiff -= now/1000000.0;
            }
            prevTime = now;
        }

        private void ProjectileHandling(List<Projectile> newProjectiles, CollisionLayer layer)
        {
            if (newProjectiles != null) {
                for (Projectile projectile : newProjectiles) {
                    EntitySprite sprite = projectile.GetSprite();
                    root.getChildren().add(sprite);

                    EntityWrapper newProjectile = new EntityWrapper(projectile, sprite, projectile.GetCollider(layer));
                    entities.put(projectile.uuid, newProjectile);
                }
            }

        }
    }

    public void SetPlayer(EntityWrapper player)
    {
        currentPlayer = player;
        entities.put(player.entity.uuid, currentPlayer);
        root.getChildren().add(player.sprite);
    }
}
