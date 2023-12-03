package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public interface IBaseCollisionChain {
    boolean collide(CollisionLayer layer1, CollisionLayer layer2);
}
