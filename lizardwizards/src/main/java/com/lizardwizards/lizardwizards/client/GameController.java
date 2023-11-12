package com.lizardwizards.lizardwizards.client;

import java.util.*;

import com.lizardwizards.lizardwizards.client.ui.GameHUD;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Pair;

public class GameController {
    HashMap<UUID, EntityWrapper> entities = new HashMap<>();
    EntityWrapper currentPlayer;
    PlayerControls playerControls = new PlayerControls();
    Canvas root;
    GraphicsContext gc;
    GameTimer currentTimer;

    GameController(Canvas root)
    {
        new GameHUD();
        this.root = root;
        gc = root.getGraphicsContext2D();
        // TODO: not this preferably
        ((Pane)root.getParent()).getChildren().addAll(GameHUD.getInstance().getHudElements());
        gc.setFont(new Font("Sans", 100));
        gc.setFill(Color.GOLDENROD);
        gc.fillText("Loading...", 500, 500);
    }
    public void start(SyncPacket syncPacket) {
        System.out.println(currentPlayer.entity.uuid);
        currentTimer = new GameTimer(syncPacket.serverTime);
        currentTimer.start();
    }

    public void initEntityList(RoomInformation room, List<EntityWrapper> players) {
        entities.clear();
        players.forEach(player -> entities.put(player.entity.uuid, player));
        entities.putAll(room.entities);

        players.sort(Comparator.comparing(a -> a.entity.uuid));
        for (EntityWrapper player : players) {
            player.SetPosition(room.getPlayerPosition());
        }
    }

    public void updateEntityList(SyncPacket syncPacket) {
        currentTimer.stop();
        syncPacket.createdEntities.forEach(pair -> {
            var entity = pair.getValue();
            entities.put(entity.entity.uuid, entity);
        });
        currentTimer.syncWithServerTimer(syncPacket, syncPacket.createdEntities);
        syncPacket.destroyedEntities.forEach((entity) -> {
            EntityWrapper canonEntity = entities.get(entity.entity.uuid);
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
                entity.MoveByDelta(delta, entities);
            });

            entities.forEach((uuid, entity) -> {
                if (syncPacket.entities.containsKey(uuid)) // this is shit, but it's also late
                {
                    entity.update(syncPacket.entities.get(uuid));
                }
            });
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
                int weaponSwitch = playerControls.HandleWeaponSwitching();
                if (weaponSwitch != 0){
                    ((Player)currentPlayer.entity).ChangeWeapon(weaponSwitch);
                }

                ClientConnectionHandler.CurrentHandler.sendUpdate(currentPlayer.entity.GetPosition() ,newMovement, newShooting, weaponSwitch);

                timeElapsed = (now-prevTime)/1000000000.0;

                entities.forEach((uuid, entity) -> { // this foreach loop updates the screen somehow
                    entity.MoveByDelta(timeElapsed, entities);
                });
            }
            else{
                serverClientDiff -= now/1000000.0;
            }
            prevTime = now;

            redraw();
        }
    }

    public synchronized HashMap<UUID, EntityWrapper> getCopyOfEntities() { // this exists only to serve UNDO
        return new HashMap<>(entities);
    }

    public void SetPlayer(EntityWrapper player)
    {
        currentPlayer = player;
        currentPlayer.addObserver(GameHUD.getInstance());
        entities.put(player.entity.uuid, currentPlayer);
    }

    private void redraw() {
        gc.clearRect(0, 0, root.getWidth(), root.getHeight());
        entities.forEach((uuid, entity) -> {
            entity.sprite.drawSprite(gc);
        });
    }
}
