package com.lizardwizards.lizardwizards.core.gameplay.enemies.state;


import com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for TimedStateChanger
 *
 * @see TimedStateChanger
 * @author povilas
 */
public class TimedStateChangerTest
{
    /**
     * Parasoft Jtest UTA: Test for getState()
     *
     * @author povilas
     * @see TimedStateChanger#getState()
     */
    @Test
    public void testGetState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double switchDelay = 0.0d; // UTA: default value
            EnemyStrategyState[] strategyStates = new com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState[1]; // UTA: default value
            TimedStateChanger underTest = new TimedStateChanger(switchDelay, strategyStates);

            // When
            EnemyStrategyState result = underTest.getState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for processDelta(double)
     *
     * @author povilas
     * @see TimedStateChanger#processDelta(double)
     */
    @Test
    public void testProcessDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double switchDelay = 0.0d; // UTA: default value
            EnemyStrategyState[] strategyStates = new com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState[1]; // UTA: default value
            TimedStateChanger underTest = new TimedStateChanger(switchDelay, strategyStates);

            // When
            double timeDelta = 0.0d; // UTA: default value
            EnemyStrategyState result = underTest.processDelta(timeDelta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shouldSwitch()
     *
     * @author povilas
     * @see TimedStateChanger#shouldSwitch()
     */
    @Test
    public void testShouldSwitch() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double switchDelay = 0.0d; // UTA: default value
            EnemyStrategyState[] strategyStates = new com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState[0]; // UTA: default value
            TimedStateChanger underTest = new TimedStateChanger(switchDelay, strategyStates);

            // When
            boolean result = underTest.shouldSwitch();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for switchState()
     *
     * @author povilas
     * @see TimedStateChanger#switchState()
     */
    @Test
    public void testSwitchState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double switchDelay = 0.0d; // UTA: default value
            EnemyStrategyState[] strategyStates = new com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState[1]; // UTA: default value
            TimedStateChanger underTest = new TimedStateChanger(switchDelay, strategyStates);

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
            double switchDelay = 0.0d; // UTA: default value
            EnemyStrategyState[] strategyStates = new com.lizardwizards.lizardwizards.core.gameplay.enemies.strategy.EnemyStrategyState[0]; // UTA: default value
            TimedStateChanger underTest = new TimedStateChanger(switchDelay, strategyStates);

            // When
            IStateChanger extraChanger = mock(IStateChanger.class);
            IStateChanger result = underTest.extraClause(extraChanger);

        });
    }
}