package com.lizardwizards.lizardwizards.core.gameplay.collision;


import com.lizardwizards.lizardwizards.core.Vector2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Line
 *
 * @see Line
 * @author povilas
 */
public class LineTest
{
    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see Line#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 start = new Vector2(0, 0);
            Vector2 end = new Vector2(0, 0);
            Line underTest = new Line(start, end);

            // When
            Line result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDirection()
     *
     * @author povilas
     * @see Line#getDirection()
     */
    @Test
    public void testGetDirection() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 start = new Vector2(0, 0);
            Vector2 end = new Vector2(0, 0);
            Line underTest = new Line(start, end);

            // When
            Vector2 result = underTest.getDirection();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getLength()
     *
     * @author povilas
     * @see Line#getLength()
     */
    @Test
    public void testGetLength() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 start = new Vector2(0, 0);
            Vector2 end = new Vector2(0, 0);
            Line underTest = new Line(start, end);

            // When
            double result = underTest.getLength();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getSlopeAndIntercept()
     *
     * @author povilas
     * @see Line#getSlopeAndIntercept()
     */
    @Test
    public void testGetSlopeAndIntercept() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 start = new Vector2(0, 0);
            Vector2 end = new Vector2(0, 0);
            Line underTest = new Line(start, end);

            // When
            List<Double> result = underTest.getSlopeAndIntercept();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for pointIsInFiniteLine(Vector2)
     *
     * @author povilas
     * @see Line#pointIsInFiniteLine(Vector2)
     */
    @Test
    public void testPointIsInFiniteLine() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 start = new Vector2(0, 0);
            Vector2 end = new Vector2(0, 0);
            Line underTest = new Line(start, end);

            // When
            Vector2 point = mock(Vector2.class);
            boolean result = underTest.pointIsInFiniteLine(point);

        });
    }
}