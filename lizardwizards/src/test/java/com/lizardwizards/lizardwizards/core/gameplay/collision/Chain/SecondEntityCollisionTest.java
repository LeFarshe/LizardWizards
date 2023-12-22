package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;


import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for SecondEntityCollision
 *
 * @see SecondEntityCollision
 * @author povilas
 */
public class SecondEntityCollisionTest
{
    /**
     * Parasoft Jtest UTA: Test for collide(CollisionLayer, CollisionLayer)
     *
     * @author povilas
     * @see SecondEntityCollision#collide(CollisionLayer, CollisionLayer)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            SecondEntityCollision underTest = new SecondEntityCollision(layer);

            // When
            CollisionLayer layer1 = CollisionLayer.Enemy; // UTA: default value
            CollisionLayer layer2 = CollisionLayer.Enemy; // UTA: default value
            boolean result = underTest.collide(layer1, layer2);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for addHandler(ICollisionChain)
     *
     * @author povilas
     * @see ICollisionChain#addHandler(ICollisionChain)
     */
    @Test
    public void testAddHandler() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            SecondEntityCollision underTest = new SecondEntityCollision(layer);

            // When
            ICollisionChain collisionHandler = mock(ICollisionChain.class);
            underTest.addHandler(collisionHandler);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for iterateOverSuccessors(CollisionLayer, CollisionLayer)
     *
     * @author povilas
     * @see ICollisionChain#iterateOverSuccessors(CollisionLayer, CollisionLayer)
     */
    @Test
    public void testIterateOverSuccessors() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            SecondEntityCollision underTest = new SecondEntityCollision(layer);

            // When
            CollisionLayer layer1 = CollisionLayer.Enemy; // UTA: default value
            CollisionLayer layer2 = CollisionLayer.Enemy; // UTA: default value
            boolean result = underTest.iterateOverSuccessors(layer1, layer2);

        });
    }
}