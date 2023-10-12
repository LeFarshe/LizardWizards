package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerTimer extends TimerTask {

    private long time;

    private final HashMap<UUID, EntityWrapper> entities;
    private final List<PlayerHandler> players;
    private final Session currentSession;
    private final LinkedList<Pair<Long, EntityWrapper>> createdEntities;
    private final List<EntityWrapper> destroyedEntities;

    public ServerTimer(RoomInformation room, Session session) {
        this.entities = new HashMap<>();
        currentSession = session;
        session.players.forEach(player -> this.entities.put(player.getPlayerUUID(), player.getPlayer()));
        this.players = session.players;
        this.createdEntities = new LinkedList<>();
        this.destroyedEntities = new LinkedList<>();
        time = 0;
        loadRoom(room);
        session.sendToPlayers(room, SentDataType.Room);
    }

    @Override
    public synchronized void run() {
        long now = (new Date()).getTime();
        double elapsedTime = (now-time) / 1000.0;

        List<UUID> toBeRemoved = new LinkedList<>();
        entities.forEach((entityUUID, entity) -> {
            entity.MoveByDelta(elapsedTime, entities);
            if (entity.entity.IsDestroyed()) {
                destroyedEntities.add(entity);
                toBeRemoved.add(entityUUID);
            }
        });
        toBeRemoved.forEach(entities::remove);

        players.forEach(player -> {
            var newProjectiles = player.processShooting(elapsedTime);
            if (newProjectiles != null){
                newProjectiles.forEach(projectile -> {
                    var entity = new EntityWrapper(projectile, projectile.GetSprite(), projectile.GetCollider(CollisionLayer.PlayerProjectile));
                    entities.put(projectile.uuid, entity);
                    createdEntities.add(new Pair<>(now, entity));
                });
            }
        });

        currentSession.sendToPlayers(getChanges(), SentDataType.SyncPacket);
        time = now;
    }

    public synchronized void loadRoom(RoomInformation room) {
        AtomicInteger i = new AtomicInteger();
        List<EntityWrapper> playersTemp = new LinkedList<>();
        entities.forEach(((uuid, entity) -> {
            if (players.stream().noneMatch(x -> entity.entity.uuid.compareTo(x.getPlayerUUID()) == 0)){
                destroyedEntities.add(entity);
                entities.remove(uuid);
            }
            else {
                playersTemp.add(entity);
            }
        }));
        playersTemp.sort(Comparator.comparing(a -> a.entity.uuid));
        playersTemp.forEach(player -> {
            player.SetPosition(room.playerStartPositions.get(i.getAndIncrement()));
        });
        entities.putAll(room.entities);
        createdEntities.clear();
    }

    public synchronized SyncPacket getChanges(){
        SyncPacket syncPacket = new SyncPacket(time,
                new HashMap<>(entities),
                new LinkedList<>(createdEntities),
                new LinkedList<>(destroyedEntities));
        createdEntities.clear();
        destroyedEntities.clear();
        return syncPacket;
    }
}
