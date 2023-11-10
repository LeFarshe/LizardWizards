package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;

import java.util.Dictionary;
public abstract class IEnemy extends Entity {
    double health;
    abstract void setRandomDirection();
    abstract void HandleDeath();
}