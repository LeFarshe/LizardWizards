package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.Utils;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.server.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for ChaseStrategyState
 *
 * @see ChaseStrategyState
 * @author povilas
 */
public class ChaseStrategyStateTest
{
    /**
     * Parasoft Jtest UTA: Test for getMovementDirection(double)
     *
     * @author povilas
     * @see ChaseStrategyState#getMovementDirection(double)
     */
    @Test
    public void testGetMovementDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy enemy = mock(Enemy.class);
            when(enemy.GetPosition()).thenReturn(new Vector2(0, 0));
            double acceleration = 0.0d; // UTA: default value
            double maxSpeed = 0.0d; // UTA: default value
            ChaseStrategyState underTest = new ChaseStrategyState(enemy, acceleration, maxSpeed);

            // When
            double delta = 0.0d; // UTA: default value
            Vector2 result = underTest.getMovementDirection(delta);

        });
    }
}