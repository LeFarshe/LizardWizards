package com.lizardwizards.lizardwizards.core.communication;


import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ConnectionInformation
 *
 * @see ConnectionInformation
 * @author povilas
 */
public class ConnectionInformationTest
{
    /**
     * Parasoft Jtest UTA: Test for execute()
     *
     * @author povilas
     * @see ConnectionInformation#execute()
     */
    @Test
    public void testExecute() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        ClientConnectionHandler.CurrentHandler = mock();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            GameState gameState = GameState.InGame; // UTA: default value
            ConnectionInformation underTest = new ConnectionInformation(gameState);

            // When
            underTest.execute();

        });
    }
}