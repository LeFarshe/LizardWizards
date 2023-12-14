package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.Server;

import java.util.List;

public class ShootState extends EnemyStrategyState {
    final IWeapon weapon;
    Vector2 target;
    public ShootState(Enemy enemy, IWeapon weapon, Vector2 target) {
        super(enemy);
        this.weapon = weapon;
        this.target = target;
    }

    @Override
    public Vector2 getMovementDirection(double delta) {
        var projectiles = weapon.ContinueShooting(delta, getTargetDirection(), parent.GetPosition());
        if (projectiles != null) {
            projectiles.forEach(p -> {
                var entity = new EntityWrapper(p, p.GetSprite(), p.GetCollider(CollisionLayer.EnemyProjectile));
                Server.serverTimer.addNewEntity(entity, p.uuid);
            });
        }
        return new Vector2(0, 0);
    }

    public Vector2 getTargetDirection() {
        return target.Copy().AddVector(parent.GetPosition().Multiply(-1)).Normalize();
    }
}
