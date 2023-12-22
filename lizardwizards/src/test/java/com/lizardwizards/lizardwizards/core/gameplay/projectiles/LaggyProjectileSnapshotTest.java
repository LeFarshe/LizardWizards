package com.lizardwizards.lizardwizards.core.gameplay.projectiles;


import com.lizardwizards.lizardwizards.core.Vector2;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for LaggyProjectileSnapshot
 *
 * @see LaggyProjectileSnapshot
 * @author povilas
 */
public class LaggyProjectileSnapshotTest
{
    /**
     * Parasoft Jtest UTA: Test for restore()
     *
     * @author povilas
     * @see LaggyProjectileSnapshot#restore()
     */
    @Test
    public void testRestore() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            IProjectile projectile = mock(IProjectile.class);
            Vector2 direction = mock(Vector2.class);
            Vector2 position = mock(Vector2.class);
            double speed = 0.0d; // UTA: default value
            double duration = 0.0d; // UTA: default value
            boolean erase = false; // UTA: default value
            LaggyProjectileSnapshot underTest = new LaggyProjectileSnapshot(projectile, direction, position, speed, duration, erase);

            // When
            underTest.restore();

        });
    }
}