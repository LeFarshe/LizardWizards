package com.lizardwizards.lizardwizards.core.gameplay.weapons;


import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.BoltEnergizerVisitor;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for TurretWand
 *
 * @see TurretWand
 * @author povilas
 */
public class TurretWandTest
{
    /**
     * Parasoft Jtest UTA: Test for Shoot(Vector2, Vector2)
     *
     * @author povilas
     * @see TurretWand#Shoot(Vector2, Vector2)
     */
    @Test
    public void testShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            List<IProjectile> result = underTest.Shoot(direction, position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for accept(BoltEnergizerVisitor)
     *
     * @author povilas
     * @see TurretWand#accept(BoltEnergizerVisitor)
     */
    @Test
    public void testAccept() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            BoltEnergizerVisitor visitor = mock(BoltEnergizerVisitor.class);
            Weapon result = underTest.accept(visitor);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getWeapon()
     *
     * @author povilas
     * @see TurretWeapon#getWeapon()
     */
    @Test
    public void testGetWeapon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            IWeapon result = underTest.getWeapon();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setWeapon(IWeapon)
     *
     * @author povilas
     * @see TurretWeapon#setWeapon(IWeapon)
     */
    @Test
    public void testSetWeapon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            IWeapon weapon = mock(IWeapon.class);
            underTest.setWeapon(weapon);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see Weapon#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            Weapon result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for AddTimeWithoutShoot(double)
     *
     * @author povilas
     * @see Weapon#AddTimeWithoutShoot(double)
     */
    @Test
    public void testAddTimeWithoutShoot() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double delta = 0.0d; // UTA: default value
            List<IProjectile> result = underTest.AddTimeWithoutShoot(delta);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for ContinueShooting(double, Vector2, Vector2)
     *
     * @author povilas
     * @see Weapon#ContinueShooting(double, Vector2, Vector2)
     */
    @Test
    public void testContinueShooting() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double delta = 0.0d; // UTA: default value
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            List<IProjectile> result = underTest.ContinueShooting(delta, direction, position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getBaseWeapon()
     *
     * @author povilas
     * @see Weapon#getBaseWeapon()
     */
    @Test
    public void testGetBaseWeapon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            Weapon result = underTest.getBaseWeapon();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDamage()
     *
     * @author povilas
     * @see Weapon#getDamage()
     */
    @Test
    public void testGetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double result = underTest.getDamage();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getFireRate()
     *
     * @author povilas
     * @see Weapon#getFireRate()
     */
    @Test
    public void testGetFireRate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double result = underTest.getFireRate();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getHudIcon()
     *
     * @author povilas
     * @see Weapon#getHudIcon()
     */
    @Test
    public void testGetHudIcon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            ImageSprite result = underTest.getHudIcon();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getProjectileSize()
     *
     * @author povilas
     * @see Weapon#getProjectileSize()
     */
    @Test
    public void testGetProjectileSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            Vector2 result = underTest.getProjectileSize();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getShotDuration()
     *
     * @author povilas
     * @see Weapon#getShotDuration()
     */
    @Test
    public void testGetShotDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double result = underTest.getShotDuration();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getShotSpeed()
     *
     * @author povilas
     * @see Weapon#getShotSpeed()
     */
    @Test
    public void testGetShotSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double result = underTest.getShotSpeed();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDamage(double)
     *
     * @author povilas
     * @see Weapon#setDamage(double)
     */
    @Test
    public void testSetDamage() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double damage = 0.0d; // UTA: default value
            underTest.setDamage(damage);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setFireRate(double)
     *
     * @author povilas
     * @see Weapon#setFireRate(double)
     */
    @Test
    public void testSetFireRate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double fireRate = 0.0d; // UTA: default value
            underTest.setFireRate(fireRate);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setProjectileSize(Vector2)
     *
     * @author povilas
     * @see Weapon#setProjectileSize(Vector2)
     */
    @Test
    public void testSetProjectileSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            Vector2 projectileSize = mock(Vector2.class);
            underTest.setProjectileSize(projectileSize);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setShotDuration(double)
     *
     * @author povilas
     * @see Weapon#setShotDuration(double)
     */
    @Test
    public void testSetShotDuration() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double duration = 0.0d; // UTA: default value
            underTest.setShotDuration(duration);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setShotSpeed(double)
     *
     * @author povilas
     * @see Weapon#setShotSpeed(double)
     */
    @Test
    public void testSetShotSpeed() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            TurretWand underTest = new TurretWand();

            // When
            double shotSpeed = 0.0d; // UTA: default value
            underTest.setShotSpeed(shotSpeed);

        });
    }
}