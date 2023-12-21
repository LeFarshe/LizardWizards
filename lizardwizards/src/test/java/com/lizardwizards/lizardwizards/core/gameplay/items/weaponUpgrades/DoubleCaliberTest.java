package com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for DoubleCaliber
 *
 * @see DoubleCaliber
 * @author povilas
 */
public class DoubleCaliberTest
{
    /**
     * Parasoft Jtest UTA: Test for applyUpgrade(IWeapon)
     *
     * @author povilas
     * @see DoubleCaliber#applyUpgrade(IWeapon)
     */
    @Test
    public void testApplyUpgrade() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            DoubleCaliber underTest = new DoubleCaliber();

            // When
            IWeapon weapon = mock(IWeapon.class);
            when(weapon.getProjectileSize()).thenReturn(new Vector2(0, 0));
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
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            DoubleCaliber underTest = new DoubleCaliber();

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
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            DoubleCaliber underTest = new DoubleCaliber();

            // When
            IWeapon weapon = mock(IWeapon.class);
            underTest.playUpgradeAnimation(weapon);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for postUpgradeActions(IWeapon)
     *
     * @author povilas
     * @see WeaponUpgrade#postUpgradeActions(IWeapon)
     */
    @Test
    public void testPostUpgradeActions() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            DoubleCaliber underTest = new DoubleCaliber();

            // When
            IWeapon weapon = mock(IWeapon.class);
            underTest.postUpgradeActions(weapon);

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
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            DoubleCaliber underTest = new DoubleCaliber();

            // When
            IWeapon weapon = mock(IWeapon.class);
            when(weapon.getProjectileSize()).thenReturn(new Vector2(0, 0));
            IWeapon result = underTest.upgrade(weapon);

        });
    }
}