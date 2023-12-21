package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for LevelDirector
 *
 * @see LevelDirector
 * @author povilas
 */
public class LevelDirectorTest
{
    /**
     * Parasoft Jtest UTA: Test for createLevel(LevelBuilder, int, int, double)
     *
     * @author povilas
     * @see LevelDirector#createLevel(LevelBuilder, int, int, double)
     */
    @Test
    public void testCreateLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LevelDirector underTest = new LevelDirector();

            // When
            LevelBuilder builder = mock(LevelBuilder.class);
            int rooms = 0; // UTA: default value
            int deadEnds = 0; // UTA: default value
            double randomFail = 0.0d; // UTA: default value
            Level result = underTest.createLevel(builder, rooms, deadEnds, randomFail);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getLevel(LevelBuilder, WeaponUpgradeFactory, int)
     *
     * @author povilas
     * @see LevelDirector#getLevel(LevelBuilder, WeaponUpgradeFactory, int)
     */
    @Test
    public void testGetLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            LevelDirector underTest = new LevelDirector();

            // When
            LevelBuilder builder = new LevelBuilder(11);
            WeaponUpgradeFactory weaponUpgradeFactory = new WeaponUpgradeFactory();
            int level = 1; // UTA: default value
            Level result = underTest.getLevel(builder, weaponUpgradeFactory, level);

        });
    }
}