package com.lizardwizards.lizardwizards.core.gameplay.items.items;


import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrade;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrades;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for WeaponUpgradeItem
 *
 * @see WeaponUpgradeItem
 * @author povilas
 */
public class WeaponUpgradeItemTest
{
    /**
     * Parasoft Jtest UTA: Test for collect(Player)
     *
     * @author povilas
     * @see WeaponUpgradeItem#collect(Player)
     */
    @Test
    public void testCollect() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponUpgrade upgrade = new WeaponUpgradeFactory().getUpgrade(WeaponUpgrades.Aggravator);
            WeaponUpgradeItem underTest = new WeaponUpgradeItem(upgrade);

            // When
            Player player = mock(Player.class);
            when(player.getCurrentWeapon()).thenReturn(mock());
            player.weapons = new ArrayList<>();
            player.weapons.add(mock());
            underTest.collect(player);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSize()
     *
     * @author povilas
     * @see com.lizardwizards.lizardwizards.core.gameplay.items.Item#getSize()
     */
    @Test
    public void testGetSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponUpgrade upgrade = new WeaponUpgradeFactory().getUpgrade(WeaponUpgrades.Aggravator);
            WeaponUpgradeItem underTest = new WeaponUpgradeItem(upgrade);

            // When
            Vector2 result = underTest.getSize();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSprite()
     *
     * @author povilas
     * @see com.lizardwizards.lizardwizards.core.gameplay.items.Item#getSprite()
     */
    @Test
    public void testGetSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            WeaponUpgrade upgrade = new WeaponUpgradeFactory().getUpgrade(WeaponUpgrades.Aggravator);
            WeaponUpgradeItem underTest = new WeaponUpgradeItem(upgrade);

            // When
            EntitySprite result = underTest.getSprite();

        });
    }
}