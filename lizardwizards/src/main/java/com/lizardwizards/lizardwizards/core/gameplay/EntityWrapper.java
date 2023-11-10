package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.EntitySprite;
import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

public class EntityWrapper implements Serializable, Cloneable {
    public Entity entity;
    public EntitySprite sprite;
    public Collider collider;
    private Vector2 position;

    public EntityWrapper(Entity entity, EntitySprite sprite, Collider collider)
    {
        this.collider = collider;
        this.entity = entity;
        this.sprite = sprite;
        position = entity.GetPosition();
    }

    public EntityWrapper(Entity entity, EntitySprite sprite)
    {
        this.entity = entity;
        this.sprite = sprite;
        position = entity.GetPosition();
    }

    public void Move(Vector2 amount){
        entity.Move(amount);
        sprite.Move(amount);
        if (collider != null) {
            collider.position = entity.GetPosition();
        }
        position = entity.GetPosition();
    }

    public synchronized void MoveByDelta(double delta, HashMap<UUID, EntityWrapper> entities){
        Vector2 currentPos = entity.GetPosition();
        entity.MoveByDelta(delta);
        if (collider != null) {
            collider.position = entity.GetPosition();
            CollisionLayer layer = collider.layer;
            for(EntityWrapper currentEntity: entities.values()){
                if (layer == CollisionLayer.Player){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.SetPosition(currentPos);
                            collider.position = currentPos.Copy();
                            break;
                        }
                    }
                    if (currentEntity.collider.layer == CollisionLayer.Enemy) {
                        if (collider.Collide(currentEntity.collider)){
                            entity.Collide(currentEntity.entity, CollisionLayer.Enemy);
                        }
                    }
                }
                if (layer == CollisionLayer.PlayerProjectile || layer == CollisionLayer.EnemyProjectile){
                    if (currentEntity.collider.layer == CollisionLayer.Obstacle){
                        if(collider.Collide(currentEntity.collider)){
                            entity.Collide(currentEntity.entity, CollisionLayer.Obstacle);
                            break;
                        }
                    }
                    if (layer == CollisionLayer.PlayerProjectile && currentEntity.collider.layer == CollisionLayer.Enemy){
                        if (collider.Collide(currentEntity.collider)){
                            entity.Collide(currentEntity.entity, CollisionLayer.Obstacle);
                            currentEntity.entity.Collide(entity, CollisionLayer.PlayerProjectile);
                        }
                    }
                }
            }
        }
        sprite.SetPosition(entity.GetPosition());
        position = entity.GetPosition();
    }

    public synchronized void SetPosition(Vector2 position){
        entity.SetPosition(position);
        sprite.SetPosition(position);
        if (collider != null) {
            collider.position = entity.GetPosition();
        }
        this.position = position;
    }

    public synchronized void SetColor(SpriteColor color) {
        sprite.SetPaint(color);
    }

    public synchronized void update(EntityWrapper entityWrapper) {
       var pos = entityWrapper.position;
       entity.SetPosition(pos);
       sprite.SetPosition(pos);
       collider.position = entityWrapper.collider.position.Copy();
       position = entity.GetPosition();
    }

    public EntityWrapper cloneAndReplacePosition() { // This is for a deep enough copy of positions
        var ew = new EntityWrapper(this.entity, this.sprite, this.collider);
        ew.position = position.Copy();
        return ew;
    }

    @Override
    public EntityWrapper clone() {
        try {
            EntityWrapper clone = (EntityWrapper) super.clone();
            if (entity != null) { clone.entity = entity.clone(); }
            if (sprite != null) { clone.sprite = sprite.clone(); }
            if (collider != null) { clone.collider = collider.clone(); }
            if (position != null) { clone.position = position.Copy(); }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
