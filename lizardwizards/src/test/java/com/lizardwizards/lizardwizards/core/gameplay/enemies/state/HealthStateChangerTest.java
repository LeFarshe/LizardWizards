package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;


import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for HealthStateChanger
 *
 * @see HealthStateChanger
 * @author povilas
 */
public class HealthStateChangerTest
{
    /**
     * Parasoft Jtest UTA: Test for getState()
     *
     * @author povilas
     * @see HealthStateChanger#getState()
     */
    @Test
    public void testGetState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy parent = mock(Enemy.class);
            double health = 0.0d; // UTA: default value
            EnemyStrategyState initialState = mock(EnemyStrategyState.class);
            EnemyStrategyState endState = mock(EnemyStrategyState.class);
            HealthStateChanger underTest = new HealthStateChanger(parent, health, initialState, endState);

            // When
            EnemyStrategyState result = underTest.getState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shouldSwitch()
     *
     * @author povilas
     * @see HealthStateChanger#shouldSwitch()
     */
    @Test
    public void testShouldSwitch() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy parent = mock(Enemy.class);
            double health = 0.0d; // UTA: default value
            EnemyStrategyState initialState = mock(EnemyStrategyState.class);
            EnemyStrategyState endState = mock(EnemyStrategyState.class);
            HealthStateChanger underTest = new HealthStateChanger(parent, health, initialState, endState);

            // When
            boolean result = underTest.shouldSwitch();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for switchState()
     *
     * @author povilas
     * @see HealthStateChanger#switchState()
     */
    @Test
    public void testSwitchState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy parent = mock(Enemy.class);
            double health = 0.0d; // UTA: default value
            EnemyStrategyState initialState = mock(EnemyStrategyState.class);
            EnemyStrategyState endState = mock(EnemyStrategyState.class);
            HealthStateChanger underTest = new HealthStateChanger(parent, health, initialState, endState);

            // When
            EnemyStrategyState result = underTest.switchState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for extraClause(IStateChanger)
     *
     * @author povilas
     * @see IStateChanger#extraClause(IStateChanger)
     */
    @Test
    public void testExtraClause() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy parent = mock(Enemy.class);
            double health = 0.0d; // UTA: default value
            EnemyStrategyState initialState = mock(EnemyStrategyState.class);
            EnemyStrategyState endState = mock(EnemyStrategyState.class);
            HealthStateChanger underTest = new HealthStateChanger(parent, health, initialState, endState);

            // When
            IStateChanger extraChanger = mock(IStateChanger.class);
            IStateChanger result = underTest.extraClause(extraChanger);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for processDelta(double)
     *
     * @author povilas
     * @see IStateChanger#processDelta(double)
     */
    @Test
    public void testProcessDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Enemy parent = mock(Enemy.class);
            double health = 0.0d; // UTA: default value
            EnemyStrategyState initialState = mock(EnemyStrategyState.class);
            EnemyStrategyState endState = mock(EnemyStrategyState.class);
            HealthStateChanger underTest = new HealthStateChanger(parent, health, initialState, endState);

            // When
            double timeDelta = 0.0d; // UTA: default value
            EnemyStrategyState result = underTest.processDelta(timeDelta);

        });
    }
}