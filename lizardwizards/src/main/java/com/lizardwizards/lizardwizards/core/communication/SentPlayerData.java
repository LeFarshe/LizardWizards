package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.io.Serializable;

public class SentPlayerData implements Serializable {
    public final Vector2 movement;
    public final Vector2 shooting;

    public SentPlayerData(Vector2 movement, Vector2 shooting) {
        this.movement = movement;
        this.shooting = shooting;
    }
}
