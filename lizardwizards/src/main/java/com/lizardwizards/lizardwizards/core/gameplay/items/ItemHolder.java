package com.lizardwizards.lizardwizards.core.gameplay.items;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.server.ServerTimer;

import java.util.Dictionary;

public class ItemHolder extends Entity {
    Item item;
    boolean isDestroyed = false;

    public ItemHolder(Vector2 position, Item item){
        this.position = position.Copy();
        this.item = item;
    }

    @Override
    public void MoveByDelta(double delta) {

    }

    @Override
    public void Collide(Entity collider, CollisionLayer layer) {
        if (!isDestroyed && layer == CollisionLayer.Player){
            isDestroyed = true;
            item.collect((Player) collider);
            ServerTimer.currentLevel.getCurrentRoom().removeItem(item);
        }
    }

    @Override
    public Dictionary<String, Integer> GetSpriteSettings() {
        return null;
    }

    @Override
    public boolean IsDestroyed() {
        return isDestroyed;
    }
}
