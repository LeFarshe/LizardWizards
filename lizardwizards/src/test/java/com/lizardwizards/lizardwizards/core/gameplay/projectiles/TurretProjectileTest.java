package com.lizardwizards.lizardwizards.core.gameplay.projectiles;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain.Handler;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import com.lizardwizards.lizardwizards.server.Server;
import com.lizardwizards.lizardwizards.server.ServerTimer;
import com.lizardwizards.lizardwizards.server.Session;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for TurretProjectile
 *
 * @see TurretProjectile
 * @author povilas
 */
public class TurretProjectileTest
{
    /**
     * Parasoft Jtest UTA: Test for GetCollider(CollisionLayer)
     *
     * @author povilas
     * @see TurretProjectile#GetCollider(CollisionLayer)
     */
    @Test
    public void testGetCollider() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            Collider result = underTest.GetCollider(layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for MoveByDelta(double)
     *
     * @author povilas
     * @see TurretProjectile#MoveByDelta(double)
     */
    @Test
    public void testMoveByDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0, 0);
            Vector2 direction = new Vector2(0, 0);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double delta = 0.0d; // UTA: default value
            underTest.MoveByDelta(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see TurretProjectile#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0,0);
            Vector2 direction = new Vector2(0,0);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            TurretProjectile result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getNearbyEnemy()
     *
     * @author povilas
     * @see TurretProjectile#getNearbyEnemy()
     */
    @Test
    public void testGetNearbyEnemy() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            EntityWrapper result = underTest.getNearbyEnemy();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getTurretSprite()
     *
     * @author povilas
     * @see TurretProjectile#getTurretSprite()
     */
    @Test
    public void testGetTurretSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            EntitySprite result = underTest.getTurretSprite();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for handle()
     *
     * @author povilas
     * @see TurretProjectile#handle()
     */
    @Test
    public void testHandle() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            underTest.handle();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setFirst()
     *
     * @author povilas
     * @see TurretProjectile#setFirst()
     */
    @Test
    public void testSetFirst() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            underTest.setFirst();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setNext(Handler)
     *
     * @author povilas
     * @see TurretProjectile#setNext(Handler)
     */
    @Test
    public void testSetNext() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Handler handler = mock(Handler.class);
            underTest.setNext(handler);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shootTurret(List)
     *
     * @author povilas
     * @see TurretProjectile#shootTurret(List)
     */
    @Test
    public void testShootTurret() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        Server.session = new Session();
        Server.serverTimer = new ServerTimer();

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            List<IProjectile> projectiles = new ArrayList<IProjectile>(); // UTA: default value
            IProjectile item = mock(IProjectile.class);
            projectiles.add(item);
            underTest.shootTurret(projectiles);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for toBeRemoved()
     *
     * @author povilas
     * @see TurretProjectile#toBeRemoved()
     */
    @Test
    public void testToBeRemoved() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            boolean result = underTest.toBeRemoved();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Collide(Entity, CollisionLayer)
     *
     * @author povilas
     * @see Projectile#Collide(Entity, CollisionLayer)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            underTest.Collide(collider, layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for GetSprite()
     *
     * @author povilas
     * @see Projectile#GetSprite()
     */
    @Test
    public void testGetSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            EntitySprite result = underTest.GetSprite();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for IsDestroyed()
     *
     * @author povilas
     * @see Projectile#IsDestroyed()
     */
    @Test
    public void testIsDestroyed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            boolean result = underTest.IsDestroyed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for createSnapshot()
     *
     * @author povilas
     * @see Projectile#createSnapshot()
     */
    @Test
    public void testCreateSnapshot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            LaggyProjectileSnapshot result = underTest.createSnapshot();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDamage()
     *
     * @author povilas
     * @see Projectile#getDamage()
     */
    @Test
    public void testGetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double result = underTest.getDamage();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDirection()
     *
     * @author povilas
     * @see Projectile#getDirection()
     */
    @Test
    public void testGetDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = new Vector2(0, 0);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Vector2 result = underTest.getDirection();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDuration()
     *
     * @author povilas
     * @see Projectile#getDuration()
     */
    @Test
    public void testGetDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double result = underTest.getDuration();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setErase(boolean)
     *
     * @author povilas
     * @see Projectile#setErase(boolean)
     */
    @Test
    public void testSetErase() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            boolean erase = false; // UTA: default value
            underTest.setErase(erase);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setSpeed(double)
     *
     * @author povilas
     * @see Projectile#setSpeed(double)
     */
    @Test
    public void testSetSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double speed = 0.0d; // UTA: default value
            underTest.setSpeed(speed);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDirection(Vector2)
     *
     * @author povilas
     * @see Projectile#setDirection(Vector2)
     */
    @Test
    public void testSetDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Vector2 direction2 = mock(Vector2.class);
            underTest.setDirection(direction2);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDuration(double)
     *
     * @author povilas
     * @see Projectile#setDuration(double)
     */
    @Test
    public void testSetDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double duration = 0.0d; // UTA: default value
            underTest.setDuration(duration);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSpeed()
     *
     * @author povilas
     * @see Projectile#getSpeed()
     */
    @Test
    public void testGetSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            double result = underTest.getSpeed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shoot(Vector2, Vector2)
     *
     * @author povilas
     * @see Projectile#shoot(Vector2, Vector2)
     */
    @Test
    public void testShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Vector2 direction2 = mock(Vector2.class);
            Vector2 position2 = mock(Vector2.class);
            Projectile result = underTest.shoot(direction2, position2);

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

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0,0);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

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

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0,0);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

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

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double shotSpeed = 0.0d; // UTA: default value
            double shotDuration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            IWeapon weapon = mock(IWeapon.class);
            TurretProjectile underTest = new TurretProjectile(damage, shotSpeed, shotDuration, position, direction, weapon);

            // When
            Vector2 position2 = mock(Vector2.class);
            underTest.SetPosition(position2);

        });
    }
}