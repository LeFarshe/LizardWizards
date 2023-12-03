package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;

public class CollisionHandler {
    static ICollisionChain collisionChain;

    public static boolean collide(EntityWrapper entity1, EntityWrapper entity2){
        if (collisionChain == null) {
            if (LizardWizardsServer.isRunning){
                collisionChain = CollisionChainBuilder.getServerChain();
            }
            else {
                collisionChain = CollisionChainBuilder.getClientChain();
            }
        }
        if (collisionChain.collide(entity1.collider.layer, entity2.collider.layer)){
            if (entity1.collider.Collide(entity2.collider)) {
                entity1.entity.Collide(entity2.entity, entity2.collider.layer);
                entity2.entity.Collide(entity1.entity, entity1.collider.layer);
                return true;
            }
        }
        return false;
    }
}
