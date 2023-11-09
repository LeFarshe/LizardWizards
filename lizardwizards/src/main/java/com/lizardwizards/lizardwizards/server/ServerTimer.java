package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SentDataType;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import javafx.util.Pair;

import java.util.*;

public class ServerTimer extends TimerTask {

    private long time;

    private LevelDirector levelDirector;
    private Level currentLevel;

    private RoomFactory roomFactory;

    private final HashMap<UUID, EntityWrapper> entities;
    private final List<PlayerHandler> players;
    private final Session currentSession;
    private final LinkedList<Pair<Long, EntityWrapper>> createdEntities;
    private final List<EntityWrapper> destroyedEntities;

    private final List<Collider> doors = new ArrayList<>();
    private boolean[] existingDoors;
    private boolean roomIsBeingChanged = false;

    public ServerTimer(Session session) {
        levelDirector = new LevelDirector();
        currentLevel = levelDirector.testLevel();
        roomFactory = new RoomFactory();

        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax / 2, 0), 20,20, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax, RoomInformation.yMax / 2), 20,20, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax), 20,20, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(0, RoomInformation.yMax / 2), 20,20, CollisionLayer.Player));

        this.entities = new HashMap<>();
        currentSession = session;
        session.players.forEach(player -> this.entities.put(player.getPlayerUUID(), player.getPlayer()));
        this.players = session.players;
        this.createdEntities = new LinkedList<>();
        this.destroyedEntities = new LinkedList<>();
        time = 0;
        loadRoom();
    }

    @Override
    public synchronized void run() {
        long now = (new Date()).getTime();
        if (time == 0)
            time = now;
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
        for(PlayerHandler player: players) {
            for (int i = 0; i < 4; i++){
                if (doors.get(i).Collide(player.getPlayer().collider) && existingDoors[i] && !roomIsBeingChanged) {
                    currentLevel.moveDirectionally(i + 1);
                    roomIsBeingChanged = true;
                    loadRoom();
                    break;
                }
            }
        }
    }

    public synchronized void loadRoom() {
        createdEntities.clear();
        RoomInformation room = roomFactory.getRoom(currentLevel);
        existingDoors = currentLevel.getDoors();
        entities.clear();
        for (PlayerHandler player: players){
            entities.put(player.getPlayerUUID(),player.getPlayer());
            player.getPlayer().SetPosition(room.getPlayerPosition());
        }
        entities.putAll(room.entities);

        currentSession.sendToPlayers(room, SentDataType.Room);
        roomIsBeingChanged = false;
    }

    public synchronized SyncPacket getChanges(){
        HashMap<UUID, EntityWrapper> entitiesCpy = new HashMap<>(entities);
        entitiesCpy.forEach(((uuid, entityWrapper) -> entitiesCpy.put(uuid, entityWrapper.cloneAndReplacePosition())));
        new LinkedList<>();
        SyncPacket syncPacket = new SyncPacket(time,
                entitiesCpy,
                new LinkedList<>(createdEntities),
                new LinkedList<>(destroyedEntities),
                Scoreboard.getInstance().getScore());
        createdEntities.clear();
        destroyedEntities.clear();
        return syncPacket;
    }
}
