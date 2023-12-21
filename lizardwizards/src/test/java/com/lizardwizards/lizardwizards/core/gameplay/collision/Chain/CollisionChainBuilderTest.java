package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for CollisionChainBuilder
 *
 * @see CollisionChainBuilder
 * @author povilas
 */
public class CollisionChainBuilderTest
{
    /**
     * Parasoft Jtest UTA: Test for getClientChain()
     *
     * @author povilas
     * @see CollisionChainBuilder#getClientChain()
     */
    @Test
    public void testGetClientChain() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            ICollisionChain result = CollisionChainBuilder.getClientChain();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getServerChain()
     *
     * @author povilas
     * @see CollisionChainBuilder#getServerChain()
     */
    @Test
    public void testGetServerChain() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            ICollisionChain result = CollisionChainBuilder.getServerChain();

        });
    }
}