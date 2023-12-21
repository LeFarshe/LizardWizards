package com.lizardwizards.lizardwizards.server;


import com.lizardwizards.lizardwizards.core.communication.SentServerData;
import com.lizardwizards.lizardwizards.core.gameplay.GameState;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Session
 *
 * @see Session
 * @author povilas
 */
public class SessionTest
{
    /**
     * Parasoft Jtest UTA: Test for updateLobby()
     *
     * @author povilas
     * @see Session#updateLobby()
     */
    @Test
    public void testUpdateLobby() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            underTest.updateLobby();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for startGame()
     *
     * @author povilas
     * @see Session#startGame()
     */
    @Test
    public void testStartGame() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            boolean result = underTest.startGame();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for sendToPlayers(SentServerData)
     *
     * @author povilas
     * @see Session#sendToPlayers(SentServerData)
     */
    @Test
    public void testSendToPlayers() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            SentServerData sentServerData = mock(SentServerData.class);
            underTest.sendToPlayers(sentServerData);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for sendToPlayers(SentServerData)
     *
     * @author povilas
     * @see Session#sendToPlayers(SentServerData)
     */
    @Test
    public void testSendToPlayers2() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            SentServerData sentServerData = mock(SentServerData.class);
            underTest.sendToPlayers(sentServerData);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getGameState()
     *
     * @author povilas
     * @see Session#getGameState()
     */
    @Test
    public void testGetGameState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            GameState result = underTest.getGameState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for addPlayer(PlayerHandler)
     *
     * @author povilas
     * @see Session#addPlayer(PlayerHandler)
     */
    @Test
    public void testAddPlayer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            PlayerHandler player = mock(PlayerHandler.class);
            underTest.addPlayer(player);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for acceptingConnections()
     *
     * @author povilas
     * @see Session#acceptingConnections()
     */
    @Test
    public void testAcceptingConnections() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Session underTest = new Session();

            // When
            boolean result = underTest.acceptingConnections();

        });
    }
}