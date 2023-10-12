package com.lizardwizards.lizardwizards.client;

import com.lizardwizards.lizardwizards.core.Vector2;

import javafx.scene.shape.Rectangle;

import java.io.Serializable;


//Rectangle is temporary
// No it's not
// Yes it is
public class EntitySprite extends Rectangle implements Serializable {
    private final Vector2 size; // TODO remove
    public EntitySprite(Vector2 position, Vector2 size)
    {
        this.size = size;
        this.setHeight(this.size.x);
        this.setWidth(this.size.y);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
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

    public void ResetSize(){ // this is here since shit broke and TODO remove
        this.setHeight(size.x);
        this.setWidth(size.y);
    }
}
