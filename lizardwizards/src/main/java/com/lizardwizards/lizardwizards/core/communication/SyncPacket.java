package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.client.ui.GameHUD;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.application.Platform;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class SyncPacket extends SentServerData{

    public final long serverTime;
    public final HashMap<UUID, EntityWrapper> entities;
    public final LinkedList<Pair<Long, EntityWrapper>> createdEntities;
    public final List<EntityWrapper> destroyedEntities;
    public final int currentScore;
    public int oldScore;
    private HashMap<UUID, EntityWrapper> oldEntities;

    public SyncPacket(long serverTime, HashMap<UUID, EntityWrapper> entities, LinkedList<Pair<Long, EntityWrapper>> createdEntities, List<EntityWrapper> destroyedEntities, int currentScore) {
        super(SentDataType.SyncPacket);
        this.serverTime = serverTime;
        this.entities = entities;
        this.createdEntities = createdEntities;
        this.destroyedEntities = destroyedEntities;
        this.currentScore = currentScore;
    }

    @Override
    public void execute() {
        addToHistory();
        Platform.runLater(() -> {
            oldScore = GameHUD.getInstance().getScore();
            GameHUD.getInstance().setScore(currentScore);
            oldEntities = ClientUtils.gameController.getCopyOfEntities();
            ClientUtils.gameController.updateEntityList(this);
        });
    }

    @Override
    public void undo() {
        var reCreated = (LinkedList<Pair<Long, EntityWrapper>>) destroyedEntities.stream()
                .map(x -> new Pair<>(serverTime, x)).toList();
        var unCreated = createdEntities.stream().map(Pair::getValue).toList();
        var undoneSyncPacket = new SyncPacket(serverTime, oldEntities, reCreated, unCreated, oldScore);
        Platform.runLater(() -> {
            GameHUD.getInstance().setScore(oldScore);
            ClientUtils.gameController.updateEntityList(undoneSyncPacket);
        });
    }
}
