package com.lizardwizards.lizardwizards.core.gameplay.collision;


import com.lizardwizards.lizardwizards.core.Vector2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Collider
 *
 * @see Collider
 * @author povilas
 */
public class ColliderTest
{
    /**
     * Parasoft Jtest UTA: Test for Clamp(double, double, double)
     *
     * @author povilas
     * @see Collider#Clamp(double, double, double)
     */
    @Test
    public void testClamp() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            double value = 0.0d; // UTA: default value
            double min = 0.0d; // UTA: default value
            double max = 0.0d; // UTA: default value
            double result = Collider.Clamp(value, min, max);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Collide(Collider)
     *
     * @author povilas
     * @see Collider#Collide(Collider)
     */
    @Test
    public void testCollide() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 centerPosition = new Vector2(0, 0);
            double radius = 0.0d; // UTA: default value
            CollisionLayer colLayer = CollisionLayer.Enemy; // UTA: default value
            Collider underTest = Collider.NewCircle(centerPosition, radius, colLayer);

            // When
            boolean result = underTest.Collide(underTest);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for IntersectLine(Line)
     *
     * @author povilas
     * @see Collider#IntersectLine(Line)
     */
    @Test
    public void testIntersectLine() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 centerPosition = mock(Vector2.class);
            double radius = 0.0d; // UTA: default value
            CollisionLayer colLayer = CollisionLayer.Enemy; // UTA: default value
            Collider underTest = Collider.NewCircle(centerPosition, radius, colLayer);

            // When
            Line line = new Line(new Vector2(0, 0), new Vector2(0, 0));
            List<Vector2> result = underTest.IntersectLine(line);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for NewCircle(Vector2, double, CollisionLayer)
     *
     * @author povilas
     * @see Collider#NewCircle(Vector2, double, CollisionLayer)
     */
    @Test
    public void testNewCircle() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Vector2 centerPosition = mock(Vector2.class);
            double radius = 0.0d; // UTA: default value
            CollisionLayer colLayer = CollisionLayer.Enemy; // UTA: default value
            Collider result = Collider.NewCircle(centerPosition, radius, colLayer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for NewRectangle(Vector2, double, double, CollisionLayer)
     *
     * @author povilas
     * @see Collider#NewRectangle(Vector2, double, double, CollisionLayer)
     */
    @Test
    public void testNewRectangle() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Vector2 centerPosition = mock(Vector2.class);
            double width = 0.0d; // UTA: default value
            double height = 0.0d; // UTA: default value
            CollisionLayer colLayer = CollisionLayer.Enemy; // UTA: default value
            Collider result = Collider.NewRectangle(centerPosition, width, height, colLayer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see Collider#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 centerPosition = mock(Vector2.class);
            double radius = 0.0d; // UTA: default value
            CollisionLayer colLayer = CollisionLayer.Enemy; // UTA: default value
            Collider underTest = Collider.NewCircle(centerPosition, radius, colLayer);

            // When
            Collider result = underTest.clone();

        });
    }
}