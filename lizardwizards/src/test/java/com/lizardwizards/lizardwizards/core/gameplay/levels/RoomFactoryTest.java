package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for RoomFactory
 *
 * @see RoomFactory
 * @author povilas
 */
public class RoomFactoryTest
{
    /**
     * Parasoft Jtest UTA: Test for getRoom(Level)
     *
     * @author povilas
     * @see RoomFactory#getRoom(Level)
     */
    @Test
    public void testGetRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomFactory underTest = new RoomFactory();

            // When
            var levelFacade = new LevelFacade();
            Level currentLevel = levelFacade.getLevel(1);
            RoomInformation result = underTest.getRoom(currentLevel);

        });
    }
}