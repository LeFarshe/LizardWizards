package com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.IStateChanger;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CompoundStateStrategy
 *
 * @see CompoundStateStrategy
 * @author povilas
 */
public class CompoundStateStrategyTest
{
    /**
     * Parasoft Jtest UTA: Test for getMovementDirection(double)
     *
     * @author povilas
     * @see CompoundStateStrategy#getMovementDirection(double)
     */
    @Test
    public void testGetMovementDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy enemy = mock(Enemy.class);
            IStateChanger stateChanger = mock(IStateChanger.class);
            CompoundStateStrategy underTest = new CompoundStateStrategy(enemy, stateChanger);

            // When
            double delta = 0.0d; // UTA: default value
            Vector2 result = underTest.getMovementDirection(delta);

        });
    }
}