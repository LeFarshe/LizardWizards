package com.lizardwizards.lizardwizards.client.sprites;

import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.GraphicsContext;

//Rectangle is temporary
// No it's not
// Yes it is
public class RectangleSprite extends EntitySprite {
    protected Vector2 size;
    private double width;
    private double height;

    public RectangleSprite(Vector2 position, Vector2 size)
    {
        this.size = size;
        this.setHeight(this.size.y);
        this.setWidth(this.size.x);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
        setPaint(new SpriteColor(0, 0, 0));
    }

    public RectangleSprite(Vector2 position, Vector2 size, SpriteColor paint)
    {
        this.size = size;
        this.setHeight(this.size.y);
        this.setWidth(this.size.x);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
        setPaint(paint);
    }

    @Override
    public void setPosition(Vector2 position)
    {
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
    }

    @Override
    public void scale(double sizeMultiplier) {
        size.Multiply(sizeMultiplier);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void drawSprite(GraphicsContext gc) {
        gc.setFill(getFill());
        gc.fillRect(position.x, position.y, width, height);
    }

    @Override
    public RectangleSprite clone(){
        RectangleSprite clone = (RectangleSprite) super.clone();

        clone.setHeight(getHeight());
        clone.setWidth(getWidth());

        if (size != null) { clone.size = size.Copy(); }

        return clone;
    }
}
