package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class RootCollisionChain extends ICollisionChain {
    @Override
    public boolean collide(CollisionLayer layer1, CollisionLayer layer2) {
        return iterateOverSuccessors(layer1, layer2);
    }
}
