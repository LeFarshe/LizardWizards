package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for KeepDistanceStrategyState
 *
 * @see KeepDistanceStrategyState
 * @author povilas
 */
public class KeepDistanceStrategyStateTest
{
    /**
     * Parasoft Jtest UTA: Test for getMovementDirection(double)
     *
     * @author povilas
     * @see KeepDistanceStrategyState#getMovementDirection(double)
     */
    @Test
    public void testGetMovementDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy enemy = mock(Enemy.class);
            when(enemy.GetPosition()).thenReturn(new Vector2(0, 0));
            double prefDistance = 0.0d; // UTA: default value
            KeepDistanceStrategyState underTest = new KeepDistanceStrategyState(enemy, prefDistance);

            // When
            double delta = 0.0d; // UTA: default value
            Vector2 result = underTest.getMovementDirection(delta);

        });
    }
}