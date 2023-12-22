package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class SpriteSheet extends EntitySprite implements Serializable{

    private final Sheet sprites;
    private EntitySprite current;


    public SpriteSheet(Sheet sprites){
        this.sprites = sprites;
        current = sprites.next();
    }

    public SpriteSheet(){
        this.sprites = new Sheet();
    }

    @Override
    public double getWidth() {
        return current.getWidth();
    }

    @Override
    public double getHeight() {
        return current.getHeight();
    }

    @Override
    public void scale(double sizeMultiplier) {
        for(int i = 0; i < sprites.size; i++){
            sprites.next().scale(sizeMultiplier);
        }
    }

    @Override
    public void setPosition(Vector2 position) {
        for(int i = 0; i < sprites.size; i++){
            sprites.next().setPosition(position);
        }
    }

    @Override
    public void drawSprite(GraphicsContext gc) {
        var sprite = sprites.next();
        sprite.drawSprite(gc);
        current = sprite;
    }

    public boolean add (EntitySprite entitySprite){
        if (current == null) {
            current = entitySprite;
        }
        return sprites.add(entitySprite);
    }

    public boolean remove (EntitySprite entitySprite){
        boolean removed = sprites.remove(entitySprite);
        if (current == entitySprite) {
            current = sprites.next();
        }
        return removed;
    }

    public List<EntitySprite> getChildren(){
        return sprites.getList();
    }
}
