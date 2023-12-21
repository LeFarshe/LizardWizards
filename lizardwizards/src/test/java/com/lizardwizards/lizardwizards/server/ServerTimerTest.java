package com.lizardwizards.lizardwizards.server;


import com.lizardwizards.lizardwizards.core.communication.SyncPacket;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain.Handler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ServerTimer
 *
 * @see ServerTimer
 * @author povilas
 */
public class ServerTimerTest
{
    /**
     * Parasoft Jtest UTA: Test for run()
     *
     * @author povilas
     * @see ServerTimer#run()
     */
    @Test
    public void testRun() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerTimer underTest = new ServerTimer();

            // When
            underTest.run();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for newLevel(int, int)
     *
     * @author povilas
     * @see ServerTimer#newLevel(int, int)
     */
    @Test
    public void testNewLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerTimer underTest = new ServerTimer();

            // When
            int nextLevel = 0; // UTA: default value
            int score = 0; // UTA: default value
            underTest.newLevel(nextLevel, score);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for loadRoom()
     *
     * @author povilas
     * @see ServerTimer#loadRoom()
     */
    @Test
    public void testLoadRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerTimer underTest = new ServerTimer();

            // When
            underTest.loadRoom();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getChanges()
     *
     * @author povilas
     * @see ServerTimer#getChanges()
     */
    @Test
    public void testGetChanges() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerTimer underTest = new ServerTimer();

            // When
            SyncPacket result = underTest.getChanges();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for addNewEntity(EntityWrapper, UUID)
     *
     * @author povilas
     * @see ServerTimer#addNewEntity(EntityWrapper, UUID)
     */
    @Test
    public void testAddNewEntity() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ServerTimer underTest = new ServerTimer();

            // When
            EntityWrapper entity = mock(EntityWrapper.class);
            UUID uuid = UUID.randomUUID();
            underTest.addNewEntity(entity, uuid);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for addChain(Handler)
     *
     * @author povilas
     * @see ServerTimer#addChain(Handler)
     */
    @Test
    public void testAddChain() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Handler handler = mock(Handler.class);
            ServerTimer.addChain(handler);

        });
    }
}