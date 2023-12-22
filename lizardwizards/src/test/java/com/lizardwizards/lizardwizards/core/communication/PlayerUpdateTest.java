package com.lizardwizards.lizardwizards.core.communication;


import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for PlayerUpdate
 *
 * @see PlayerUpdate
 * @author povilas
 */
public class PlayerUpdateTest
{
    /**
     * Parasoft Jtest UTA: Test for execute()
     *
     * @author povilas
     * @see PlayerUpdate#execute()
     */
    @Test
    public void testExecute() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        ClientConnectionHandler.CurrentHandler = mock();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EntityWrapper player = mock(EntityWrapper.class);
            player.entity = new Player(new Vector2(0, 0), 0);
            PlayerUpdate underTest = new PlayerUpdate(player);

            // When
            underTest.execute();

        });
    }
}