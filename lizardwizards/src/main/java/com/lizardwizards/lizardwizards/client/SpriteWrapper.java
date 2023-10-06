package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.Projectile;

import java.util.List;

public class SpriteWrapper {
    public Entity entity;
    public EntitySprite sprite;

    public Collider collider;

    public SpriteWrapper(Entity entity, EntitySprite sprite, Collider collider)
    {
        this.collider = collider;
        this.entity = entity;
        this.sprite = sprite;
    }

    public SpriteWrapper(Entity entity, EntitySprite sprite)
    {
        this.entity = entity;
        this.sprite = sprite;
    }

    public void Move(Vector2 amount){
        entity.Move(amount);
        sprite.Move(amount);
        if (collider != null) {
            collider.position = entity.GetPosition();
        }
    }

    public void MoveByDelta(double delta, List<SpriteWrapper> entities){
        Vector2 currentpos = entity.GetPosition();
        entity.MoveByDelta(delta);
        if (collider != null) {
            collider.position = entity.GetPosition();
            CollisionLayer layer = collider.layer;
            for(SpriteWrapper currentEntity: entities){
                if (layer == CollisionLayer.Player){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.SetPosition(currentpos);
                            collider.position = currentpos.Copy();
                            break;
                        }
                    }
                    if (currentEntity.collider.layer == CollisionLayer.Enemy) {
                        if (collider.Collide(currentEntity.collider)){
                            entity.Collide(CollisionLayer.Enemy);
                        }
                    }
                }
                if (layer == CollisionLayer.PlayerProjectile || layer == CollisionLayer.EnemyProjectile){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.Collide(CollisionLayer.Obstacle);
                        }
                    }
                    if (layer == CollisionLayer.PlayerProjectile && currentEntity.collider.layer == CollisionLayer.Enemy){
                        if (collider.Collide(currentEntity.collider)){
                            entity.Collide(CollisionLayer.Obstacle);
                            currentEntity.entity.Collide(CollisionLayer.PlayerProjectile);
                        }
                    }
                }
            }
        }
        sprite.SetPosition(entity.GetPosition());
    }

    public void SetPosition(Vector2 position){
        entity.SetPosition(position);
        sprite.SetPosition(position);
        if (collider != null) {
            collider.position = entity.GetPosition();
        }
    }
}
