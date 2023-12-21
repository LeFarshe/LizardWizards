package com.lizardwizards.lizardwizards.server;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for ServerCommands
 *
 * @see ServerCommands
 * @author povilas
 */
public class ServerCommandsTest
{
    /**
     * Parasoft Jtest UTA: Test for checkMatch(String)
     *
     * @author povilas
     * @see ServerCommands#checkMatch(String)
     */
    @Test
    public void testCheckMatch() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerCommands underTest = ServerCommands.HELP;

            // When
            String command = "command"; // UTA: default value
            boolean result = underTest.checkMatch(command);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for execute(String...)
     *
     * @author povilas
     * @see ServerCommands#execute(String...)
     */
    @Test
    public void testExecute() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerCommands underTest = ServerCommands.HELP;

            // When
            String[] args = new String[0]; // UTA: default value
            underTest.execute(args);

        });
    }
}