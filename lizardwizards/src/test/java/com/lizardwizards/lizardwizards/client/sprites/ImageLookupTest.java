package com.lizardwizards.lizardwizards.client.sprites;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for ImageLookup
 *
 * @see ImageLookup
 * @author povilas
 */
public class ImageLookupTest
{
    /**
     * Parasoft Jtest UTA: Test for getImageSize(String)
     *
     * @author povilas
     * @see ImageLookup#getImageSize(String)
     */
    @Test
    public void testGetImageSize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            String filename = "images/loading.png"; // UTA: default value
            Vector2 result = ImageLookup.getImageSize(filename);

        });
    }
}