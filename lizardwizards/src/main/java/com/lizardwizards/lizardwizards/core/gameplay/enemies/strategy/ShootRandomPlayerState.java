package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

import static com.lizardwizards.lizardwizards.core.gameplay.Utils.getRandomPlayer;

public class ShootRandomPlayerState extends ShootState {
    final double aggroDelay;
    double aggroTimer;
    Entity currentTarget;
    public ShootRandomPlayerState(Enemy enemy, IWeapon weapon, double aggroDelay) {
        super(enemy, weapon, new Vector2(0, 0));
        this.aggroDelay = aggroDelay;
        currentTarget = getRandomPlayer();
        target = currentTarget.GetPosition();
        aggroTimer = aggroDelay;
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        aggroTimer -= delta;
        if (aggroTimer < 0) {
            currentTarget = getRandomPlayer();
            aggroTimer = aggroDelay;
        }
        target = currentTarget.GetPosition();
        return super.getMovementDirection(delta);
    }
}
