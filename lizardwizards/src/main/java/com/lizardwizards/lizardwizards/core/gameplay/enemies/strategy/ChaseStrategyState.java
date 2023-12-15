package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.Utils;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;

public class ChaseStrategyState extends EnemyStrategyState {
    double acceleration;
    final double maxSpeed;
    Vector2 speed;
    Entity target;
    public ChaseStrategyState(Enemy enemy, double acceleration, double maxSpeed) {
        super(enemy);
        this.maxSpeed = maxSpeed;
        target = Utils.getRandomPlayer();
        this.acceleration = acceleration;
        speed = new Vector2(0, 0);
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        if (target.IsDestroyed() && Utils.isServer()) {
            target = Utils.getRandomPlayer();
            return new Vector2(0, 0);
        }
        if (speed.DistanceTo(new Vector2(0, 0)) > maxSpeed) {
            speed.Normalize().Multiply(maxSpeed);
        }
        var direction = parent.GetPosition().Multiply(-1).AddVector(target.GetPosition());
        speed.AddVector(direction.Multiply(acceleration));
        return speed.Copy();
    }
}
