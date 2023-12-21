package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;


import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for DefaultStateChanger
 *
 * @see DefaultStateChanger
 * @author povilas
 */
public class DefaultStateChangerTest
{
    /**
     * Parasoft Jtest UTA: Test for getState()
     *
     * @author povilas
     * @see DefaultStateChanger#getState()
     */
    @Test
    public void testGetState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyStrategyState enemyStrategyState = mock(EnemyStrategyState.class);
            DefaultStateChanger underTest = new DefaultStateChanger(enemyStrategyState);

            // When
            EnemyStrategyState result = underTest.getState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for processDelta(double)
     *
     * @author povilas
     * @see DefaultStateChanger#processDelta(double)
     */
    @Test
    public void testProcessDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyStrategyState enemyStrategyState = mock(EnemyStrategyState.class);
            DefaultStateChanger underTest = new DefaultStateChanger(enemyStrategyState);

            // When
            double timeDelta = 0.0d; // UTA: default value
            EnemyStrategyState result = underTest.processDelta(timeDelta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shouldSwitch()
     *
     * @author povilas
     * @see DefaultStateChanger#shouldSwitch()
     */
    @Test
    public void testShouldSwitch() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyStrategyState enemyStrategyState = mock(EnemyStrategyState.class);
            DefaultStateChanger underTest = new DefaultStateChanger(enemyStrategyState);

            // When
            boolean result = underTest.shouldSwitch();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for switchState()
     *
     * @author povilas
     * @see DefaultStateChanger#switchState()
     */
    @Test
    public void testSwitchState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyStrategyState enemyStrategyState = mock(EnemyStrategyState.class);
            DefaultStateChanger underTest = new DefaultStateChanger(enemyStrategyState);

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
            EnemyStrategyState enemyStrategyState = mock(EnemyStrategyState.class);
            DefaultStateChanger underTest = new DefaultStateChanger(enemyStrategyState);

            // When
            IStateChanger extraChanger = mock(IStateChanger.class);
            IStateChanger result = underTest.extraClause(extraChanger);

        });
    }
}