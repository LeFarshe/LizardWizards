package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.*;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.levels.Level;
import com.lizardwizards.lizardwizards.core.gameplay.levels.LevelFacade;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain.Handler;
import javafx.util.Pair;

import java.util.*;

public class ServerTimer extends TimerTask {

    private long time;
    public static Level currentLevel;
    private final LevelFacade levelFacade;
    public final HashMap<UUID, EntityWrapper> entities = new HashMap<>();
    private final List<PlayerHandler> players;
    private final Session currentSession;
    private final LinkedList<Pair<Long, EntityWrapper>> createdEntities;
    private final List<EntityWrapper> destroyedEntities;
    private static final HashMap<UUID, EntityWrapper> newEntities = new HashMap<>();
    private static final List<Handler> chains = new ArrayList<>();

    private final List<Collider> doors = new ArrayList<>();
    private final Collider trapDoor;
    private boolean[] existingDoors;
    private int enemyCount;

    public ServerTimer() {
        levelFacade = new LevelFacade();
        currentLevel = levelFacade.getLevel(1);

        trapDoor = Collider.NewRectangle(new Vector2(RoomInformation.xMax / 2,RoomInformation.yMax / 5), 32,32, CollisionLayer.Player);
        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax / 2, 0), 55,20, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax, RoomInformation.yMax / 2), 20,55, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax), 55,20, CollisionLayer.Player));
        doors.add(Collider.NewRectangle(new Vector2(0, RoomInformation.yMax / 2), 20,55, CollisionLayer.Player));

        currentSession = Server.session;
        currentSession.players.forEach(player -> entities.put(player.getPlayerUUID(), player.getPlayer()));
        this.players = currentSession.players;
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
                if (entity.entity instanceof Enemy){
                    enemyCount --;
                    if (enemyCount == 0){
                        currentLevel.getCurrentRoom().setCleared();
                    }
                }
                destroyedEntities.add(entity);
                toBeRemoved.add(entityUUID);
            }
        });
        toBeRemoved.forEach(entities::remove);

        int chainLoop = 0;
        while (chainLoop < chains.size()){
            Handler handler = chains.get(chainLoop);
            handler.handle();
            if (handler.toBeRemoved()){
                chains.remove(chainLoop);
            }
            else{
                chainLoop++;
            }
        }

        newEntities.forEach((entityUUID, entity) ->{
            entities.put(entityUUID, entity);
            createdEntities.add(new Pair<>(now, entity));
        });
        newEntities.clear();

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

        currentSession.sendToPlayers(getChanges());
        time = now;
        for(PlayerHandler player: players) {
            for (int i = 0; i < 4; i++){
                if (currentLevel.getCurrentRoom().isBossRoom() && currentLevel.getCurrentRoom().isCleared() && trapDoor.Collide(player.getPlayer().collider)){
                    newLevel(currentLevel.level + 1, 100 * currentLevel.level);
                }
                if (enemyCount <= 0 && doors.get(i).Collide(player.getPlayer().collider) && existingDoors[i]) {
                    currentLevel.moveDirectionally(i + 1);
                    loadRoom();
                    break;
                }
            }
        }
    }

    public synchronized void loadRoom() {
        createdEntities.clear();
        RoomInformation room = levelFacade.getRoom(currentLevel);
        enemyCount = room.enemyCount;
        existingDoors = currentLevel.getDoors();
        entities.clear();
        newEntities.clear();
        chains.clear();
        for (PlayerHandler player: players){
            entities.put(player.getPlayerUUID(),player.getPlayer());
            player.getPlayer().SetPosition(room.getPlayerPosition());
        }
        entities.putAll(room.entities);

        currentSession.sendToPlayers(room);
    }

    public synchronized SyncPacket getChanges(){
        HashMap<UUID, EntityWrapper> entitiesCpy = new HashMap<>(entities);
        entitiesCpy.forEach(((uuid, entityWrapper) -> entitiesCpy.put(uuid, entityWrapper.clone())));
        new LinkedList<>();
        SyncPacket syncPacket = new SyncPacket(time,
                entitiesCpy,
                new LinkedList<>(createdEntities),
                new LinkedList<>(destroyedEntities));
        createdEntities.clear();
        destroyedEntities.clear();
        return syncPacket;
    }

    public synchronized static void addChain(Handler handler){
        chains.add(handler);
    }

    public synchronized static void addNewEntity(EntityWrapper entity, UUID uuid){
        newEntities.put(uuid, entity);
    }
    public synchronized void newLevel(int nextLevel, int score){
        currentLevel = levelFacade.getLevel(nextLevel);
        Scoreboard.getInstance().addScore(score);
        loadRoom();
    }
}
