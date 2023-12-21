package com.lizardwizards.lizardwizards.server;


import org.junit.jupiter.api.Test;

import java.net.ServerSocket;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Server
 *
 * @see Server
 * @author povilas
 */
public class ServerTest
{
    /**
     * Parasoft Jtest UTA: Test for run()
     *
     * @author povilas
     * @see Server#run()
     */
    @Test
    public void testRun() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerSocket serverSocket = new ServerSocket();
            Server underTest = new Server(serverSocket);

            // When
            underTest.run();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for stopServer()
     *
     * @author povilas
     * @see Server#stopServer()
     */
    @Test
    public void testStopServer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerSocket serverSocket = mock(ServerSocket.class);
            Server underTest = new Server(serverSocket);

            // When
            underTest.stopServer();

        });
    }
}