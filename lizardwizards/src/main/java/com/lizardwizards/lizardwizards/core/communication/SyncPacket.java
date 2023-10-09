package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import javafx.util.Pair;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class SyncPacket implements Serializable {

    public final long serverTime;
    public final HashMap<UUID, EntityWrapper> entities;
    public final LinkedList<Pair<Long, EntityWrapper>> createdEntities;
    public final List<EntityWrapper> destroyedEntities;

    public SyncPacket(long serverTime, HashMap<UUID, EntityWrapper> entities, LinkedList<Pair<Long, EntityWrapper>> createdEntities, List<EntityWrapper> destroyedEntities) {
        this.serverTime = serverTime;
        this.entities = entities;
        this.createdEntities = createdEntities;
        this.destroyedEntities = destroyedEntities;
    }
}
