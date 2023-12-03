package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class SecondEntityCollision extends ICollisionChain {
    CollisionLayer layer;

    public SecondEntityCollision(CollisionLayer layer){
        this.layer = layer;
    }
    @Override
    public boolean collide(CollisionLayer layer1, CollisionLayer layer2) {
        if (layer2 == layer){
            return iterateOverSuccessors(layer1, layer2);
        }
        return false;
    }
}
