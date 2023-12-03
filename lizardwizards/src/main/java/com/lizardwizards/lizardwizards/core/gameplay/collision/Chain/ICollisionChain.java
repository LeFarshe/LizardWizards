package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.ArrayList;
import java.util.List;

public abstract class ICollisionChain implements IBaseCollisionChain {
    List<IBaseCollisionChain> successors = new ArrayList<>();

    boolean iterateOverSuccessors(CollisionLayer layer1, CollisionLayer layer2){
        if (successors.isEmpty()) { return true; }
        for (IBaseCollisionChain successor: successors){
            if (successor.collide(layer1, layer2)){
                return true;
            }
        }
        return false;
    }
     public void addHandler(ICollisionChain collisionHandler){
        successors.add(collisionHandler);
     }
}
