package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;

import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

public class CollisionChainBuilder {
    public static ICollisionChain getServerChain(){
        RootCollisionChain handler = new RootCollisionChain();

        FirstEntityCollision playerHandler = new FirstEntityCollision(CollisionLayer.Player);
        handler.addHandler(playerHandler);
        SecondEntityCollision playerObstacleHandler = new SecondEntityCollision(CollisionLayer.Obstacle);
        playerHandler.addHandler(playerObstacleHandler);
        SecondEntityCollision playerEnemyHandler = new SecondEntityCollision(CollisionLayer.Enemy);
        playerHandler.addHandler(playerEnemyHandler);
        SecondEntityCollision playerItemHandler = new SecondEntityCollision(CollisionLayer.Item);
        playerHandler.addHandler(playerItemHandler);

        FirstEntityCollision pProjectileHandler = new FirstEntityCollision(CollisionLayer.PlayerProjectile);
        handler.addHandler(pProjectileHandler);
        SecondEntityCollision pProjectileObstacleHandler = new SecondEntityCollision(CollisionLayer.Obstacle);
        pProjectileHandler.addHandler(pProjectileObstacleHandler);
        SecondEntityCollision pProjectileEnemyHandler = new SecondEntityCollision(CollisionLayer.Enemy);
        pProjectileHandler.addHandler(pProjectileEnemyHandler);

        FirstEntityCollision eProjectileHandler = new FirstEntityCollision(CollisionLayer.EnemyProjectile);
        handler.addHandler(eProjectileHandler);
        SecondEntityCollision eProjectileObstacleHandler = new SecondEntityCollision(CollisionLayer.Obstacle);
        eProjectileHandler.addHandler(eProjectileObstacleHandler);
        SecondEntityCollision eProjectilePlayerHandler = new SecondEntityCollision(CollisionLayer.Player);
        eProjectileHandler.addHandler(eProjectilePlayerHandler);

        return handler;
    }

    public static ICollisionChain getClientChain(){
        RootCollisionChain handler = new RootCollisionChain();

        FirstEntityCollision playerHandler = new FirstEntityCollision(CollisionLayer.Player);
        handler.addHandler(playerHandler);
        SecondEntityCollision playerObstacleHandler = new SecondEntityCollision(CollisionLayer.Obstacle);
        playerHandler.addHandler(playerObstacleHandler);

        return handler;
    }
}
