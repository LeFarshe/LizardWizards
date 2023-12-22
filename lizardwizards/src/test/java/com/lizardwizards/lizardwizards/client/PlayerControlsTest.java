package com.lizardwizards.lizardwizards.client;


import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for PlayerControls
 *
 * @see PlayerControls
 * @author povilas
 */
public class PlayerControlsTest
{
    /**
     * Parasoft Jtest UTA: Test for HandleMovement()
     *
     * @author povilas
     * @see PlayerControls#HandleMovement()
     */
    @Test
    public void testHandleMovement() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            Vector2 result = underTest.HandleMovement();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for HandleShooting()
     *
     * @author povilas
     * @see PlayerControls#HandleShooting()
     */
    @Test
    public void testHandleShooting() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            Vector2 result = underTest.HandleShooting();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for HandleWeaponSwitching()
     *
     * @author povilas
     * @see PlayerControls#HandleWeaponSwitching()
     */
    @Test
    public void testHandleWeaponSwitching() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            int result = underTest.HandleWeaponSwitching();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetMovementEvents(Scene)
     *
     * @author povilas
     * @see PlayerControls#SetMovementEvents(Scene)
     */
    @Test
    public void testSetMovementEvents() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            Scene scene = mock(Scene.class);
            underTest.SetMovementEvents(scene);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetShootingEvents(Scene)
     *
     * @author povilas
     * @see PlayerControls#SetShootingEvents(Scene)
     */
    @Test
    public void testSetShootingEvents() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            Scene scene = mock(Scene.class);
            underTest.SetShootingEvents(scene);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetWeaponSwitchingEvents(Scene)
     *
     * @author povilas
     * @see PlayerControls#SetWeaponSwitchingEvents(Scene)
     */
    @Test
    public void testSetWeaponSwitchingEvents() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            PlayerControls underTest = new PlayerControls();

            // When
            Scene scene = mock(Scene.class);
            underTest.SetWeaponSwitchingEvents(scene);

        });
    }
}