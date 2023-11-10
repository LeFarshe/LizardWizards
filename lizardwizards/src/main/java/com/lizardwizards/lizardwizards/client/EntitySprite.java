package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.Serializable;


//Rectangle is temporary
// No it's not
// Yes it is
public class EntitySprite extends Rectangle implements Serializable, Cloneable {
    private Vector2 size; // TODO remove
    private SpriteColor paint;
    public EntitySprite(Vector2 position, Vector2 size)
    {
        this.size = size;
        this.setHeight(this.size.y);
        this.setWidth(this.size.x);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
        paint = new SpriteColor(0, 0, 0);
        setFill(Color.BLACK);
    }

    public EntitySprite(Vector2 position, Vector2 size, SpriteColor paint)
    {
        this.size = size;
        this.setHeight(this.size.y);
        this.setWidth(this.size.x);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
        this.paint = paint;
        setFill(adaptSpriteColor(paint));
    }
    public void Move(Vector2 position) {
        setTranslateX(getTranslateX() + position.x);
        setTranslateY(getTranslateY() + position.y);
    }
    public void SetPosition(Vector2 position)
    {
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
    }

    public void ResetSprite(){ // this is here since shit broke and TODO remove
        this.setHeight(size.y);
        this.setWidth(size.x);
        this.setFill(adaptSpriteColor(paint));
    }

    public void Resize(double sizeMultiplier) {
        size.Multiply(sizeMultiplier);
        ResetSprite();
    }

    public void SetPaint(SpriteColor color) {
        this.paint = color;
        setFill(adaptSpriteColor(paint));
    }

    @Override
    public EntitySprite clone(){
        try {
            EntitySprite clone = (EntitySprite) super.clone();

            clone.setHeight(getHeight());
            clone.setWidth(getWidth());
            clone.setTranslateX(getTranslateX());
            clone.setTranslateY(getTranslateY());

            if (size != null) { clone.size = size.Copy(); }

            return clone;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private Paint adaptSpriteColor(SpriteColor spriteColor) {
        return new Color(spriteColor.red, spriteColor.green, spriteColor.blue, spriteColor.opacity);
    }
}
