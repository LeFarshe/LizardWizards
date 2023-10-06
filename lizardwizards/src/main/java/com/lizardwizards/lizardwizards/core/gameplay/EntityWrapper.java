package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.HashMap;
import java.util.UUID;

public class EntityWrapper {
    public Entity entity;
    public EntitySprite sprite;

    public Collider collider;

    public EntityWrapper(Entity entity, EntitySprite sprite, Collider collider)
    {
        this.collider = collider;
        this.entity = entity;
        this.sprite = sprite;
    }

    public EntityWrapper(Entity entity, EntitySprite sprite)
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

    public void MoveByDelta(double delta, HashMap<UUID, EntityWrapper> entities){
        Vector2 currentpos = entity.GetPosition();
        entity.MoveByDelta(delta);
        if (collider != null) {
            collider.position = entity.GetPosition();
            CollisionLayer layer = collider.layer;
            for(EntityWrapper currentEntity: entities.values()){
                if (layer == CollisionLayer.Player){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.SetPosition(currentpos);
                            collider.position = currentpos.Copy();
                            break;
                        }
                    }
                }
                if (layer == CollisionLayer.PlayerProjectile || layer == CollisionLayer.EnemyProjectile){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.IsDestroyed();
                            break;
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

    public void update(EntityWrapper entityWrapper) {
        entity = entityWrapper.entity;
        collider = entityWrapper.collider;
    }
}
