package com.lizardwizards.lizardwizards.core.gameplay.collision.Chain;


import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CollisionHandler
 *
 * @see CollisionHandler
 * @author povilas
 */
public class CollisionHandlerTest
{
    /**
     * Parasoft Jtest UTA: Test for collide(EntityWrapper, EntityWrapper)
     *
     * @author povilas
     * @see CollisionHandler#collide(EntityWrapper, EntityWrapper)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            EntityWrapper entity1 = new EntityWrapper(mock(), mock(), mock());
            EntityWrapper entity2 = new EntityWrapper(mock(), mock(), mock());
            boolean result = CollisionHandler.collide(entity1, entity2);

        });
    }
}