package com.lizardwizards.lizardwizards.core.gameplay.enemies;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator.EnemyMediator;
import com.lizardwizards.lizardwizards.server.Scoreboard;

public abstract class BossEnemy extends Enemy {
    public BossEnemy(double health, double speed, Vector2 position) {
        super(health, speed, position, new EnemyMediator());
        scoreReward = 100;
        Scoreboard.getInstance().initBossHealth(health);
    }

    @Override
    public boolean takeDamage(double damage) {
        Scoreboard.getInstance().subtractBossHealth(damage);
        return super.takeDamage(damage);
    }

    @Override
    public void HandleDeath() {
        super.HandleDeath();
        var s = Scoreboard.getInstance();
        if (s.getBossHealth() > 0){
            return;
        }
        Scoreboard.getInstance().resetBossHealth();
    }
}
