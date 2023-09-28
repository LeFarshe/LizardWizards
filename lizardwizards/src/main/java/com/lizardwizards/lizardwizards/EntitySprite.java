package com.lizardwizards.lizardwizards;

import javafx.scene.shape.Rectangle;


//Rectangle is temporary
public class EntitySprite extends Rectangle {
    EntitySprite(Vector2 position)
    {
        setTranslateX(position.x);
        setTranslateY(position.y);
    }
    void Move(Vector2 position)
    {
        setTranslateX(position.x);
        setTranslateY(position.y);
    }
}
