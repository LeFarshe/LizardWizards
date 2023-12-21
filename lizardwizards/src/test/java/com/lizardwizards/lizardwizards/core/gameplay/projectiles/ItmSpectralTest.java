package com.lizardwizards.lizardwizards.core.gameplay.projectiles;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ItmSpectral
 *
 * @see ItmSpectral
 * @author povilas
 */
public class ItmSpectralTest
{
    /**
     * Parasoft Jtest UTA: Test for Collide(Entity, CollisionLayer)
     *
     * @author povilas
     * @see ItmSpectral#Collide(Entity, CollisionLayer)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

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
     * @see ItmSpectral#GetSprite()
     */
    @Test
    public void testGetSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = new Projectile(0, 0, 0, mock(), mock(), new RectangleSprite(new Vector2(0, 0)));
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            EntitySprite result = underTest.GetSprite();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see ItmSpectral#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            IProjectile result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for GetCollider(CollisionLayer)
     *
     * @author povilas
     * @see ProjectileDecorator#GetCollider(CollisionLayer)
     */
    @Test
    public void testGetCollider() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            Collider result = underTest.GetCollider(layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for GetPosition()
     *
     * @author povilas
     * @see ProjectileDecorator#GetPosition()
     */
    @Test
    public void testGetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 result = underTest.GetPosition();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for IsDestroyed()
     *
     * @author povilas
     * @see ProjectileDecorator#IsDestroyed()
     */
    @Test
    public void testIsDestroyed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            boolean result = underTest.IsDestroyed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Move(Vector2)
     *
     * @author povilas
     * @see ProjectileDecorator#Move(Vector2)
     */
    @Test
    public void testMove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 amount = mock(Vector2.class);
            underTest.Move(amount);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for MoveByDelta(double)
     *
     * @author povilas
     * @see ProjectileDecorator#MoveByDelta(double)
     */
    @Test
    public void testMoveByDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double delta = 0.0d; // UTA: default value
            underTest.MoveByDelta(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetPosition(Vector2)
     *
     * @author povilas
     * @see ProjectileDecorator#SetPosition(Vector2)
     */
    @Test
    public void testSetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 position = mock(Vector2.class);
            underTest.SetPosition(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for createSnapshot()
     *
     * @author povilas
     * @see ProjectileDecorator#createSnapshot()
     */
    @Test
    public void testCreateSnapshot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            LaggyProjectileSnapshot result = underTest.createSnapshot();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDamage()
     *
     * @author povilas
     * @see ProjectileDecorator#getDamage()
     */
    @Test
    public void testGetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double result = underTest.getDamage();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDirection()
     *
     * @author povilas
     * @see ProjectileDecorator#getDirection()
     */
    @Test
    public void testGetDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 result = underTest.getDirection();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDuration()
     *
     * @author povilas
     * @see ProjectileDecorator#getDuration()
     */
    @Test
    public void testGetDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double result = underTest.getDuration();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSpeed()
     *
     * @author povilas
     * @see ProjectileDecorator#getSpeed()
     */
    @Test
    public void testGetSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double result = underTest.getSpeed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDirection(Vector2)
     *
     * @author povilas
     * @see ProjectileDecorator#setDirection(Vector2)
     */
    @Test
    public void testSetDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 direction = mock(Vector2.class);
            underTest.setDirection(direction);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDuration(double)
     *
     * @author povilas
     * @see ProjectileDecorator#setDuration(double)
     */
    @Test
    public void testSetDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double duration = 0.0d; // UTA: default value
            underTest.setDuration(duration);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setErase(boolean)
     *
     * @author povilas
     * @see ProjectileDecorator#setErase(boolean)
     */
    @Test
    public void testSetErase() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            boolean erase = false; // UTA: default value
            underTest.setErase(erase);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setSpeed(double)
     *
     * @author povilas
     * @see ProjectileDecorator#setSpeed(double)
     */
    @Test
    public void testSetSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            double speed = 0.0d; // UTA: default value
            underTest.setSpeed(speed);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for shoot(Vector2, Vector2)
     *
     * @author povilas
     * @see ProjectileDecorator#shoot(Vector2, Vector2)
     */
    @Test
    public void testShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            ItmSpectral underTest = new ItmSpectral(projectile);

            // When
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            IProjectile result = underTest.shoot(direction, position);

        });
    }
}