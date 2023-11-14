package com.lizardwizards.lizardwizards.core.gameplay.collision;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;

import java.util.List;

public class RaycastResult {
    EntityWrapper entity;
    List<Vector2> hits;

    public RaycastResult(EntityWrapper entity, List<Vector2> hits){
        this.entity = entity;
        this.hits = hits;
    }
}
