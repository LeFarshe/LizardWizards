package com.lizardwizards.lizardwizards.core.gameplay.projectiles;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Projectile
 *
 * @see Projectile
 * @author povilas
 */
public class ProjectileTest
{
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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            underTest.Collide(collider, layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for GetCollider(CollisionLayer)
     *
     * @author povilas
     * @see Projectile#GetCollider(CollisionLayer)
     */
    @Test
    public void testGetCollider() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0, 0);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = new Vector2(0, 0);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            Collider result = underTest.GetCollider(layer);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            boolean result = underTest.IsDestroyed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for MoveByDelta(double)
     *
     * @author povilas
     * @see Projectile#MoveByDelta(double)
     */
    @Test
    public void testMoveByDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0, 0);
            Vector2 direction = new Vector2(0, 0);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            double delta = 0.0d; // UTA: default value
            underTest.MoveByDelta(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see Projectile#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            Projectile result = underTest.clone();

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = new Vector2(0, 0);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            double result = underTest.getDuration();

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            double result = underTest.getSpeed();

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            double duration2 = 0.0d; // UTA: default value
            underTest.setDuration(duration2);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            double speed2 = 0.0d; // UTA: default value
            underTest.setSpeed(speed2);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double damage = 0.0d; // UTA: default value
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0, 0);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = new Vector2(0, 0);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

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
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            Vector2 position = mock(Vector2.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 spriteSize = mock(Vector2.class);
            Projectile underTest = new Projectile(damage, speed, duration, position, direction, spriteSize);

            // When
            Vector2 position2 = mock(Vector2.class);
            underTest.SetPosition(position2);

        });
    }
}