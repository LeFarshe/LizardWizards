package com.lizardwizards.lizardwizards.client.loading;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for ConcreteResourceLoader
 *
 * @see ConcreteResourceLoader
 * @author povilas
 */
public class ConcreteResourceLoaderTest
{
    /**
     * Parasoft Jtest UTA: Test for loadResources()
     *
     * @author povilas
     * @see ConcreteResourceLoader#loadResources()
     */
    @Test
    public void testLoadResources() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            ConcreteResourceLoader underTest = new ConcreteResourceLoader();

            // When
            underTest.loadResources();

        });
    }
}