package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Utils;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.server.Server;

public class KeepDistanceStrategyState extends EnemyStrategyState {
    double prefDistance;
    Vector2 target;
    public KeepDistanceStrategyState(Enemy enemy, double prefDistance) {
        super(enemy);
        this.prefDistance = prefDistance;
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        target = getClosestPlayer();
        var direction = parent.GetPosition().Multiply(-1).AddVector(target).Normalize();
        if (target.DistanceTo(parent.GetPosition()) < prefDistance) {
            return direction.Multiply(-1);
        }
        return direction;
    }

    private Vector2 getClosestPlayer() {
        if (!Utils.isServer()) {
            return parent.GetPosition();
        }
        Vector2 closestTarget = new Vector2(9999, 9999);
        Vector2 parentPosition = parent.GetPosition();
        for (var player : Server.serverTimer.players) {
            var playerPos = player.getPlayer().entity.GetPosition();
            if (playerPos.DistanceTo(parentPosition) < closestTarget.DistanceTo(parentPosition)) {
                closestTarget = playerPos;
            }
        }
        return closestTarget;
    }
}
