package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for LevelFacade
 *
 * @see LevelFacade
 * @author povilas
 */
public class LevelFacadeTest
{
    /**
     * Parasoft Jtest UTA: Test for getCustomLevel(int, int, double)
     *
     * @author povilas
     * @see LevelFacade#getCustomLevel(int, int, double)
     */
    @Test
    public void testGetCustomLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LevelFacade underTest = new LevelFacade();

            // When
            int rooms = 1; // UTA: default value
            int deadEnds = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            Level result = underTest.getCustomLevel(rooms, deadEnds, randomFail);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getLevel(int)
     *
     * @author povilas
     * @see LevelFacade#getLevel(int)
     */
    @Test
    public void testGetLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LevelFacade underTest = new LevelFacade();

            // When
            int level = 0; // UTA: default value
            Level result = underTest.getLevel(level);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getRoom(Level)
     *
     * @author povilas
     * @see LevelFacade#getRoom(Level)
     */
    @Test
    public void testGetRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LevelFacade underTest = new LevelFacade();

            // When
            Level level = underTest.getLevel(1);
            RoomInformation result = underTest.getRoom(level);

        });
    }
}