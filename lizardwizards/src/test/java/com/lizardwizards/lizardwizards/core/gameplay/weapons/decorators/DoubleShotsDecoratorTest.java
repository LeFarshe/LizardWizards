package com.lizardwizards.lizardwizards.core.gameplay.weapons.decorators;


import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Weapon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for DoubleShotsDecorator
 *
 * @see DoubleShotsDecorator
 * @author povilas
 */
public class DoubleShotsDecoratorTest
{
    /**
     * Parasoft Jtest UTA: Test for ContinueShooting(double, Vector2, Vector2)
     *
     * @author povilas
     * @see DoubleShotsDecorator#ContinueShooting(double, Vector2, Vector2)
     */
    @Test
    public void testContinueShooting() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double delta = 0.0d; // UTA: default value
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            List<IProjectile> result = underTest.ContinueShooting(delta, direction, position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see DoubleShotsDecorator#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            DoubleShotsDecorator result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for AddTimeWithoutShoot(double)
     *
     * @author povilas
     * @see WeaponDecorator#AddTimeWithoutShoot(double)
     */
    @Test
    public void testAddTimeWithoutShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double delta = 0.0d; // UTA: default value
            List<IProjectile> result = underTest.AddTimeWithoutShoot(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Shoot(Vector2, Vector2)
     *
     * @author povilas
     * @see WeaponDecorator#Shoot(Vector2, Vector2)
     */
    @Test
    public void testShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            List<IProjectile> result = underTest.Shoot(direction, position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getBaseWeapon()
     *
     * @author povilas
     * @see WeaponDecorator#getBaseWeapon()
     */
    @Test
    public void testGetBaseWeapon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            Weapon result = underTest.getBaseWeapon();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDamage()
     *
     * @author povilas
     * @see WeaponDecorator#getDamage()
     */
    @Test
    public void testGetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double result = underTest.getDamage();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getFireRate()
     *
     * @author povilas
     * @see WeaponDecorator#getFireRate()
     */
    @Test
    public void testGetFireRate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double result = underTest.getFireRate();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getHudIcon()
     *
     * @author povilas
     * @see WeaponDecorator#getHudIcon()
     */
    @Test
    public void testGetHudIcon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            ImageSprite result = underTest.getHudIcon();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getProjectileSize()
     *
     * @author povilas
     * @see WeaponDecorator#getProjectileSize()
     */
    @Test
    public void testGetProjectileSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            Vector2 result = underTest.getProjectileSize();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getShotDuration()
     *
     * @author povilas
     * @see WeaponDecorator#getShotDuration()
     */
    @Test
    public void testGetShotDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double result = underTest.getShotDuration();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getShotSpeed()
     *
     * @author povilas
     * @see WeaponDecorator#getShotSpeed()
     */
    @Test
    public void testGetShotSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double result = underTest.getShotSpeed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDamage(double)
     *
     * @author povilas
     * @see WeaponDecorator#setDamage(double)
     */
    @Test
    public void testSetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double damage = 0.0d; // UTA: default value
            underTest.setDamage(damage);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setFireRate(double)
     *
     * @author povilas
     * @see WeaponDecorator#setFireRate(double)
     */
    @Test
    public void testSetFireRate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double fireRate = 0.0d; // UTA: default value
            underTest.setFireRate(fireRate);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setProjectileSize(Vector2)
     *
     * @author povilas
     * @see WeaponDecorator#setProjectileSize(Vector2)
     */
    @Test
    public void testSetProjectileSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            Vector2 shotSize = mock(Vector2.class);
            underTest.setProjectileSize(shotSize);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setShotDuration(double)
     *
     * @author povilas
     * @see WeaponDecorator#setShotDuration(double)
     */
    @Test
    public void testSetShotDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double duration = 0.0d; // UTA: default value
            underTest.setShotDuration(duration);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setShotSpeed(double)
     *
     * @author povilas
     * @see WeaponDecorator#setShotSpeed(double)
     */
    @Test
    public void testSetShotSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IWeapon weapon = mock(IWeapon.class);
            DoubleShotsDecorator underTest = new DoubleShotsDecorator(weapon);

            // When
            double shotSpeed = 0.0d; // UTA: default value
            underTest.setShotSpeed(shotSpeed);

        });
    }
}