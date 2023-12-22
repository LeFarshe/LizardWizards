package com.lizardwizards.lizardwizards.client;


import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ClientUtils
 *
 * @see ClientUtils
 * @author povilas
 */
public class ClientUtilsTest
{
    /**
     * Parasoft Jtest UTA: Test for loadResource(String)
     *
     * @author povilas
     * @see ClientUtils#loadResource(String)
     */
    @Test
    public void testLoadResource() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            String locationInResourceFolder = "locationInResourceFolder"; // UTA: default value
            URL result = ClientUtils.loadResource(locationInResourceFolder);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setScreen(Stage)
     *
     * @author povilas
     * @see ClientUtils#setScreen(Stage)
     */
    @Test
    public void testSetScreen() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Stage window = mock(Stage.class);
            ClientUtils.setScreen(window);

        });
    }
}