package com.lizardwizards.lizardwizards.core.gameplay.weapons;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for WeaponFactory
 *
 * @see WeaponFactory
 * @author povilas
 */
public class WeaponFactoryTest
{
    /**
     * Parasoft Jtest UTA: Test for getWeapon(WeaponTypes)
     *
     * @author povilas
     * @see WeaponFactory#getWeapon(WeaponTypes)
     */
    @Test
    public void testGetWeapon() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponFactory underTest = new WeaponFactory();

            // When
            WeaponTypes weapon = WeaponTypes.Chaingun; // UTA: default value
            IWeapon result = underTest.getWeapon(weapon);

        });
    }
}