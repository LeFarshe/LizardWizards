package com.lizardwizards.lizardwizards.core.gameplay.enemies;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.state.IStateChanger;
import com.lizardwizards.lizardwizards.server.*;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for CicadaWizardEnemy
 *
 * @see CicadaWizardEnemy
 * @author povilas
 */
public class CicadaWizardEnemyTest
{
    /**
     * Parasoft Jtest UTA: Test for Collide(Entity, CollisionLayer)
     *
     * @author povilas
     * @see CicadaWizardEnemy#Collide(Entity, CollisionLayer)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            underTest.Collide(collider, layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSprite()
     *
     * @author povilas
     * @see CicadaWizardEnemy#getSprite()
     */
    @Test
    public void testGetSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            EntitySprite result = underTest.getSprite();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for HandleDeath()
     *
     * @author povilas
     * @see BossEnemy#HandleDeath()
     */
    @Test
    public void testHandleDeath() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            underTest.HandleDeath();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for takeDamage(double)
     *
     * @author povilas
     * @see BossEnemy#takeDamage(double)
     */
    @Test
    public void testTakeDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            double damage = 0.0d; // UTA: default value
            boolean result = underTest.takeDamage(damage);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for IsDestroyed()
     *
     * @author povilas
     * @see Enemy#IsDestroyed()
     */
    @Test
    public void testIsDestroyed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            boolean result = underTest.IsDestroyed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for MoveByDelta(double)
     *
     * @author povilas
     * @see Enemy#MoveByDelta(double)
     */
    @Test
    public void testMoveByDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = new Vector2(0, 0);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            double delta = 0.0d; // UTA: default value
            underTest.MoveByDelta(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getHealth()
     *
     * @author povilas
     * @see Enemy#getHealth()
     */
    @Test
    public void testGetHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            double result = underTest.getHealth();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for nextState()
     *
     * @author povilas
     * @see Enemy#nextState()
     */
    @Test
    public void testNextState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            underTest.nextState();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for switchStateSwitcher(IStateChanger)
     *
     * @author povilas
     * @see Enemy#switchStateSwitcher(IStateChanger)
     */
    @Test
    public void testSwitchStateSwitcher() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            IStateChanger stateChanger = mock(IStateChanger.class);
            underTest.switchStateSwitcher(stateChanger);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for GetPosition()
     *
     * @author povilas
     * @see Entity#GetPosition()
     */
    @Test
    public void testGetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = new Vector2(0, 0);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            Vector2 result = underTest.GetPosition();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Move(Vector2)
     *
     * @author povilas
     * @see Entity#Move(Vector2)
     */
    @Test
    public void testMove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = new Vector2(0, 0);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            Vector2 amount = mock(Vector2.class);
            underTest.Move(amount);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetPosition(Vector2)
     *
     * @author povilas
     * @see Entity#SetPosition(Vector2)
     */
    @Test
    public void testSetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            Vector2 position2 = mock(Vector2.class);
            underTest.SetPosition(position2);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see Entity#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;
        Server.session = new Session();
        PlayerHandler mockPlayer = mock();
        when(mockPlayer.getPlayer()).thenReturn(new EntityWrapper(new Player(new Vector2(0, 0), 0), mock()));
        Server.session.addPlayer(mockPlayer);
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 position = mock(Vector2.class);
            CicadaWizardEnemy underTest = new CicadaWizardEnemy(position);

            // When
            Entity result = underTest.clone();

        });
    }
}