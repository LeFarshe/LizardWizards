package com.lizardwizards.lizardwizards.core.gameplay.collision;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Raycast
 *
 * @see Raycast
 * @author povilas
 */
public class RaycastTest
{
    /**
     * Parasoft Jtest UTA: Test for collidingRaycast(Line, List)
     *
     * @author povilas
     * @see Raycast#collidingRaycast(Line, List)
     */
    @Test
    public void testCollidingRaycast() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Line ray = new Line(new Vector2(0, 0), new Vector2(0, 0));
            List<EntityWrapper> entities = new ArrayList<EntityWrapper>(); // UTA: default value
            EntityWrapper item = new EntityWrapper(mock(), mock(), mock());
            entities.add(item);
            List<CollisionLayer> hittableLayers = new ArrayList<CollisionLayer>(); // UTA: default value
            CollisionLayer item2 = CollisionLayer.Enemy; // UTA: default value
            hittableLayers.add(item2);
            List<CollisionLayer> stoppingLayers = new ArrayList<CollisionLayer>(); // UTA: default value
            CollisionLayer item3 = CollisionLayer.Enemy; // UTA: default value
            stoppingLayers.add(item3);
            List<RaycastResult> result = Raycast.collidingRaycast(ray, entities, hittableLayers, stoppingLayers);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for raycast(Line, List)
     *
     * @author povilas
     * @see Raycast#raycast(Line, List)
     */
    @Test
    public void testRaycast() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Line ray = new Line(new Vector2(0, 0), new Vector2(0, 0));
            List<EntityWrapper> entities = new ArrayList<EntityWrapper>(); // UTA: default value
            EntityWrapper item = new EntityWrapper(mock(), mock(), mock());
            entities.add(item);
            List<CollisionLayer> hittableLayers = new ArrayList<CollisionLayer>(); // UTA: default value
            CollisionLayer item2 = CollisionLayer.Enemy; // UTA: default value
            hittableLayers.add(item2);
            List<RaycastResult> result = Raycast.raycast(ray, entities, hittableLayers);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for raycastFirstHit(Line, List)
     *
     * @author povilas
     * @see Raycast#raycastFirstHit(Line, List)
     */
    @Test
    public void testRaycastFirstHit() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Line ray = mock(Line.class);
            List<EntityWrapper> entities = new ArrayList<EntityWrapper>(); // UTA: default value
            EntityWrapper item = new EntityWrapper(mock(), mock(), mock());
            entities.add(item);
            List<CollisionLayer> hittableLayers = new ArrayList<CollisionLayer>(); // UTA: default value
            CollisionLayer item2 = CollisionLayer.Enemy; // UTA: default value
            hittableLayers.add(item2);
            RaycastResult result = Raycast.raycastFirstHit(ray, entities, hittableLayers);

        });
    }
}