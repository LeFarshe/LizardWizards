package com.lizardwizards.lizardwizards.client.sprites;

import javafx.scene.canvas.GraphicsContext;

import java.util.function.Supplier;

public class SpriteFunction extends EntitySprite {
    Supplier<EntitySprite> spriteSupplier;
    EntitySprite currentSprite;

    public SpriteFunction(Supplier<EntitySprite> spriteSupplier) {
        this.spriteSupplier = spriteSupplier;
        currentSprite = spriteSupplier.get();
    }

    @Override
    public double getWidth() {
        return currentSprite.getWidth();
    }

    @Override
    public double getHeight() {
        return currentSprite.getHeight();
    }

    @Override
    public void scale(double sizeMultiplier) {
        currentSprite.scale(sizeMultiplier);
    }

    //TODO: this is a dirty little hack
    public void updateSupplier(Supplier<EntitySprite> supplier) {
        spriteSupplier = supplier;
    }

    @Override
    public void drawSprite(GraphicsContext gc) {
        currentSprite = spriteSupplier.get();
        currentSprite.setPosition(position);
        currentSprite.drawSprite(gc);
    }
}
