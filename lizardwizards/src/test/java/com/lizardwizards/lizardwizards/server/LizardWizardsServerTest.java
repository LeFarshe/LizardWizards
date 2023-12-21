package com.lizardwizards.lizardwizards.server;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for LizardWizardsServer
 *
 * @see LizardWizardsServer
 * @author povilas
 */
public class LizardWizardsServerTest
{
    /**
     * Parasoft Jtest UTA: Test for startServer()
     *
     * @author povilas
     * @see LizardWizardsServer#startServer()
     */
    @Test
    public void testStartServer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            LizardWizardsServer.startServer();

        });
    }
}