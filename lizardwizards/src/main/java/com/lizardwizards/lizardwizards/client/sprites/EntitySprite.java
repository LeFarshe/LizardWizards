package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.Serializable;

public abstract class EntitySprite implements Serializable, Cloneable {
    private SpriteColor paint = new SpriteColor(0, 0, 0);
    protected Vector2 position = new Vector2(0, 0);

    public Paint getFill() {
        return adaptSpriteColor(paint);
    }

    public void setPaint(SpriteColor color) {
        this.paint = color;
    }

    private Paint adaptSpriteColor(SpriteColor spriteColor) {
        return new Color(spriteColor.red, spriteColor.green, spriteColor.blue, spriteColor.opacity);
    }

    public void setTranslateX(double x){
        position.x = x;
    }

    public double getTranslateX(){
        return position.x;
    }

    public void setTranslateY(double y){
        position.y = y;
    }

    public double getTranslateY(){
        return position.y;
    }

    public abstract double getWidth();

    public abstract double getHeight();

    public void setPosition(Vector2 position)
    {
        setTranslateX(position.x);
        setTranslateY(position.y);
    }

    public void move(Vector2 position) {
        setTranslateX(getTranslateX() + position.x);
        setTranslateY(getTranslateY() + position.y);
    }

    public abstract void scale(double sizeMultiplier);

    public abstract void drawSprite(GraphicsContext gc);

    @Override
    public EntitySprite clone(){
        try {
            EntitySprite clone = (EntitySprite) super.clone();

            if (position != null) { clone.position = position.Copy(); }
            clone.setPaint(new SpriteColor(paint.red, paint.green, paint.blue, paint.opacity));


            return clone;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
