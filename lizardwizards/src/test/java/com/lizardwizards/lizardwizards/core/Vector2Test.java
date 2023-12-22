package com.lizardwizards.lizardwizards.core;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Vector2
 *
 * @see Vector2
 * @author povilas
 */
public class Vector2Test
{
    /**
     * Parasoft Jtest UTA: Test for AddVector(Vector2)
     *
     * @author povilas
     * @see Vector2#AddVector(Vector2)
     */
    @Test
    public void testAddVector() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            Vector2 vector = mock(Vector2.class);
            Vector2 result = underTest.AddVector(vector);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Copy()
     *
     * @author povilas
     * @see Vector2#Copy()
     */
    @Test
    public void testCopy() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            Vector2 result = underTest.Copy();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for DistanceTo(Vector2)
     *
     * @author povilas
     * @see Vector2#DistanceTo(Vector2)
     */
    @Test
    public void testDistanceTo() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            Vector2 secondPoint = mock(Vector2.class);
            double result = underTest.DistanceTo(secondPoint);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Multiply(double)
     *
     * @author povilas
     * @see Vector2#Multiply(double)
     */
    @Test
    public void testMultiply() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            double multiplier = 0.0d; // UTA: default value
            Vector2 result = underTest.Multiply(multiplier);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Normalize()
     *
     * @author povilas
     * @see Vector2#Normalize()
     */
    @Test
    public void testNormalize() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            Vector2 result = underTest.Normalize();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for Rotate(double)
     *
     * @author povilas
     * @see Vector2#Rotate(double)
     */
    @Test
    public void testRotate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            double rad = 0.0d; // UTA: default value
            Vector2 result = underTest.Rotate(rad);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetAll(double, double)
     *
     * @author povilas
     * @see Vector2#SetAll(double, double)
     */
    @Test
    public void testSetAll() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            double x = 0.0d; // UTA: default value
            double y = 0.0d; // UTA: default value
            Vector2 underTest = new Vector2(x, y);

            // When
            double x2 = 0.0d; // UTA: default value
            double y2 = 0.0d; // UTA: default value
            underTest.SetAll(x2, y2);

        });
    }
}