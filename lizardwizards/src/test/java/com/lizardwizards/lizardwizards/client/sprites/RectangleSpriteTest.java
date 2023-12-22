package com.lizardwizards.lizardwizards.client.sprites;


import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for RectangleSprite
 *
 * @see RectangleSprite
 * @author povilas
 */
public class RectangleSpriteTest
{
    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see RectangleSprite#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            RectangleSprite result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for drawSprite(GraphicsContext)
     *
     * @author povilas
     * @see RectangleSprite#drawSprite(GraphicsContext)
     */
    @Test
    public void testDrawSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            GraphicsContext gc = mock();
            underTest.drawSprite(gc);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getHeight()
     *
     * @author povilas
     * @see RectangleSprite#getHeight()
     */
    @Test
    public void testGetHeight() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double result = underTest.getHeight();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getWidth()
     *
     * @author povilas
     * @see RectangleSprite#getWidth()
     */
    @Test
    public void testGetWidth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double result = underTest.getWidth();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for scale(double)
     *
     * @author povilas
     * @see RectangleSprite#scale(double)
     */
    @Test
    public void testScale() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double sizeMultiplier = 0.0d; // UTA: default value
            underTest.scale(sizeMultiplier);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setHeight(double)
     *
     * @author povilas
     * @see RectangleSprite#setHeight(double)
     */
    @Test
    public void testSetHeight() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double height = 0.0d; // UTA: default value
            underTest.setHeight(height);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setPosition(Vector2)
     *
     * @author povilas
     * @see RectangleSprite#setPosition(Vector2)
     */
    @Test
    public void testSetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            Vector2 position = mock(Vector2.class);
            underTest.setPosition(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setWidth(double)
     *
     * @author povilas
     * @see RectangleSprite#setWidth(double)
     */
    @Test
    public void testSetWidth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double width = 0.0d; // UTA: default value
            underTest.setWidth(width);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getFill()
     *
     * @author povilas
     * @see EntitySprite#getFill()
     */
    @Test
    public void testGetFill() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            Paint result = underTest.getFill();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getTranslateX()
     *
     * @author povilas
     * @see EntitySprite#getTranslateX()
     */
    @Test
    public void testGetTranslateX() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double result = underTest.getTranslateX();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getTranslateY()
     *
     * @author povilas
     * @see EntitySprite#getTranslateY()
     */
    @Test
    public void testGetTranslateY() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double result = underTest.getTranslateY();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for move(Vector2)
     *
     * @author povilas
     * @see EntitySprite#move(Vector2)
     */
    @Test
    public void testMove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            Vector2 position = mock(Vector2.class);
            underTest.move(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setPaint(SpriteColor)
     *
     * @author povilas
     * @see EntitySprite#setPaint(SpriteColor)
     */
    @Test
    public void testSetPaint() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            SpriteColor color = mock(SpriteColor.class);
            underTest.setPaint(color);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setTranslateX(double)
     *
     * @author povilas
     * @see EntitySprite#setTranslateX(double)
     */
    @Test
    public void testSetTranslateX() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double x = 0.0d; // UTA: default value
            underTest.setTranslateX(x);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setTranslateY(double)
     *
     * @author povilas
     * @see EntitySprite#setTranslateY(double)
     */
    @Test
    public void testSetTranslateY() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Vector2 size = mock(Vector2.class);
            RectangleSprite underTest = new RectangleSprite(size);

            // When
            double y = 0.0d; // UTA: default value
            underTest.setTranslateY(y);

        });
    }
}