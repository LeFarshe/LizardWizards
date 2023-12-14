package com.lizardwizards.lizardwizards.client.sprites;

import javafx.scene.canvas.GraphicsContext;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpriteSheet extends EntitySprite implements Iterable<EntitySprite> {

    private final List<EntitySprite> sprites ;
    private Iterator<EntitySprite> spriteIterator;
    private EntitySprite current;

    public SpriteSheet(List<EntitySprite> sprites){
        this.sprites = sprites;
        this.spriteIterator = iterator();
        current = sprites.get(0);
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
        this.forEach(sprite -> {
            sprite.scale(sizeMultiplier);
        });
    }


    @Override
    public void drawSprite(GraphicsContext gc) {
        if (!spriteIterator.hasNext()){
            this.spriteIterator = sprites.listIterator();
        }
        var sprite = spriteIterator.next();
        sprite.drawSprite(gc);
        current = sprite;
    }

    public void add (EntitySprite entitySprite){
        sprites.add(entitySprite);
    }

    @Override
    public Iterator<EntitySprite> iterator() {
        return sprites.iterator();
    }
}
