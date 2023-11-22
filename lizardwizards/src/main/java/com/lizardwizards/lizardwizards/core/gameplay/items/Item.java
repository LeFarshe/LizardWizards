package com.lizardwizards.lizardwizards.core.gameplay.items;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;

import java.io.Serializable;

public abstract class Item implements Serializable {
    protected EntitySprite sprite;
    Vector2 size;

    public Item(EntitySprite sprite, Vector2 size){
        this.sprite = sprite.clone();
        this.size = size.Copy();
    }
    public abstract void collect(Player player);
    public EntitySprite getSprite() { return sprite; }
    public Vector2 getSize() {return size;}
}
