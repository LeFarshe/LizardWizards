package com.lizardwizards.lizardwizards.core;

import javafx.scene.shape.Rectangle;


//Rectangle is temporary
// No it's not
public class EntitySprite extends Rectangle {
    EntitySprite(Vector2 position, Vector2 size)
    {
        this.setHeight(size.x);
        this.setWidth(size.y);
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
    }
    void Move(Vector2 position)
    {
        setTranslateX(position.x - this.getWidth() / 2);
        setTranslateY(position.y - this.getHeight() / 2);
    }
}
