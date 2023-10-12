package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.io.Serializable;

public class SentPlayerData implements Serializable {
    public final Vector2 position;
    public final Vector2 movement;
    public final Vector2 shooting;
    public final int weaponSwitch;

    public SentPlayerData(Vector2 position, Vector2 movement, Vector2 shooting, int weaponSwitch) {
        this.position = position;
        this.movement = movement;
        this.shooting = shooting;
        this.weaponSwitch = weaponSwitch;
    }
}
