package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for WeaponUpgradeFactory
 *
 * @see WeaponUpgradeFactory
 * @author povilas
 */
public class WeaponUpgradeFactoryTest
{
    /**
     * Parasoft Jtest UTA: Test for getRandomUpgrade()
     *
     * @author povilas
     * @see WeaponUpgradeFactory#getRandomUpgrade()
     */
    @Test
    public void testGetRandomUpgrade() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponUpgradeFactory underTest = new WeaponUpgradeFactory();

            // When
            WeaponUpgrade result = underTest.getRandomUpgrade();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getUpgrade(WeaponUpgrades)
     *
     * @author povilas
     * @see WeaponUpgradeFactory#getUpgrade(WeaponUpgrades)
     */
    @Test
    public void testGetUpgrade() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponUpgradeFactory underTest = new WeaponUpgradeFactory();

            // When
            WeaponUpgrades upgrade = WeaponUpgrades.Aggravator; // UTA: default value
            WeaponUpgrade result = underTest.getUpgrade(upgrade);

        });
    }
}