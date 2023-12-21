package com.lizardwizards.lizardwizards.core.gameplay;


import com.lizardwizards.lizardwizards.client.ClientUtils;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import com.lizardwizards.lizardwizards.server.Server;
import com.lizardwizards.lizardwizards.server.ServerTimer;
import com.lizardwizards.lizardwizards.server.Session;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Utils
 *
 * @see Utils
 * @author povilas
 */
public class UtilsTest
{
    /**
     * Parasoft Jtest UTA: Test for getEntityList()
     *
     * @author povilas
     * @see Utils#getEntityList()
     */
    @Test
    public void testGetEntityList() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        ClientUtils.gameController = mock();
        LizardWizardsServer.isRunning = false;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            HashMap<UUID, EntityWrapper> result = Utils.getEntityList();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getRandomPlayer()
     *
     * @author povilas
     * @see Utils#getRandomPlayer()
     */
    @Test
    public void testGetRandomPlayer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Player result = Utils.getRandomPlayer();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for isServer()
     *
     * @author povilas
     * @see Utils#isServer()
     */
    @Test
    public void testIsServer() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            boolean result = Utils.isServer();

        });
    }
}