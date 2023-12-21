package com.lizardwizards.lizardwizards.client.loading;


import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for ResourceLoaderProxy
 *
 * @see ResourceLoaderProxy
 * @author Legion
 */
public class ResourceLoaderProxyTest
{
    /**
     * Parasoft Jtest UTA: Test for loadResources()
     *
     * @author Legion
     * @see ResourceLoaderProxy#loadResources()
     */
    @Test
    public void testLoadResources() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ConcreteResourceLoader realLoader = mock(ConcreteResourceLoader.class);
            GraphicsContext gc = null; // UTA: default value
            ResourceLoaderProxy underTest = new ResourceLoaderProxy(realLoader, gc);

            // When
            underTest.loadResources();

        });
    }
}