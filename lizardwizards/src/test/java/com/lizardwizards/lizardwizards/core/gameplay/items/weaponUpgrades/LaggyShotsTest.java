package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for LaggyShots
 *
 * @see LaggyShots
 * @author povilas
 */
public class LaggyShotsTest
{
    /**
     * Parasoft Jtest UTA: Test for applyUpgrade(IWeapon)
     *
     * @author povilas
     * @see LaggyShots#applyUpgrade(IWeapon)
     */
    @Test
    public void testApplyUpgrade() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LaggyShots underTest = new LaggyShots();

            // When
            IWeapon weapon = mock(IWeapon.class);
            IWeapon result = underTest.applyUpgrade(weapon);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSprite()
     *
     * @author povilas
     * @see WeaponUpgrade#getSprite()
     */
    @Test
    public void testGetSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LaggyShots underTest = new LaggyShots();

            // When
            EntitySprite result = underTest.getSprite();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for playUpgradeAnimation(IWeapon)
     *
     * @author povilas
     * @see WeaponUpgrade#playUpgradeAnimation(IWeapon)
     */
    @Test
    public void testPlayUpgradeAnimation() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LaggyShots underTest = new LaggyShots();

            // When
            IWeapon weapon = mock(IWeapon.class);
            underTest.playUpgradeAnimation(weapon);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for upgrade(IWeapon)
     *
     * @author povilas
     * @see WeaponUpgrade#upgrade(IWeapon)
     */
    @Test
    public void testUpgrade() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LaggyShots underTest = new LaggyShots();

            // When
            IWeapon weapon = mock(IWeapon.class);
            IWeapon result = underTest.upgrade(weapon);

        });
    }
}