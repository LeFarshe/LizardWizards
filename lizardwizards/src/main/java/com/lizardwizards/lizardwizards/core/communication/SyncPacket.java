package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SyncPacket {

    public final long serverTime;
    public final HashMap<UUID, EntityWrapper> entities;
    public final HashMap<Long, EntityWrapper> createdEntities;
    public final List<EntityWrapper> destroyedEntities;

    public SyncPacket(long serverTime, HashMap<UUID, EntityWrapper> entities, HashMap<Long, EntityWrapper> createdEntities, List<EntityWrapper> destroyedEntities) {
        this.serverTime = serverTime;
        this.entities = entities;
        this.createdEntities = createdEntities;
        this.destroyedEntities = destroyedEntities;
    }
}
