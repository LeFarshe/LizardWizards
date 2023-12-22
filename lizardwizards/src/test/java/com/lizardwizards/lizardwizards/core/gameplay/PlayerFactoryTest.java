package com.lizardwizards.lizardwizards.core.gameplay;


import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for PlayerFactory
 *
 * @see PlayerFactory
 * @author povilas
 */
public class PlayerFactoryTest
{
    /**
     * Parasoft Jtest UTA: Test for getPlayer(PlayerClass)
     *
     * @author povilas
     * @see PlayerFactory#getPlayer(PlayerClass)
     */
    @Test
    public void testGetPlayer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            PlayerClass playerClass = PlayerClass.Blizzard; // UTA: default value
            EntityWrapper result = PlayerFactory.getPlayer(playerClass);

        });
    }
}