package com.lizardwizards.lizardwizards.client.sprites;


import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.core.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for SpriteFunction
 *
 * @see SpriteFunction
 * @author povilas
 */
public class SpriteFunctionTest
{
    /**
     * Parasoft Jtest UTA: Test for drawSprite(GraphicsContext)
     *
     * @author povilas
     * @see SpriteFunction#drawSprite(GraphicsContext)
     */
    @Test
    public void testDrawSprite() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = () -> new RectangleSprite(new Vector2(0, 0));
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            GraphicsContext gc = mock();
            underTest.drawSprite(gc);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getHeight()
     *
     * @author povilas
     * @see SpriteFunction#getHeight()
     */
    @Test
    public void testGetHeight() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = () -> new RectangleSprite(new Vector2(0, 0));
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            double result = underTest.getHeight();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getWidth()
     *
     * @author povilas
     * @see SpriteFunction#getWidth()
     */
    @Test
    public void testGetWidth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = () -> new RectangleSprite(new Vector2(0, 0));
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            double result = underTest.getWidth();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for scale(double)
     *
     * @author povilas
     * @see SpriteFunction#scale(double)
     */
    @Test
    public void testScale() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = () -> new RectangleSprite(new Vector2(0, 0));
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            double sizeMultiplier = 0.0d; // UTA: default value
            underTest.scale(sizeMultiplier);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for updateSupplier(Supplier)
     *
     * @author povilas
     * @see SpriteFunction#updateSupplier(Supplier)
     */
    @Test
    public void testUpdateSupplier() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            Supplier<EntitySprite> supplier = mock(Supplier.class);
            underTest.updateSupplier(supplier);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see EntitySprite#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            EntitySprite result = underTest.clone();

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            SpriteColor color = mock(SpriteColor.class);
            underTest.setPaint(color);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setPosition(Vector2)
     *
     * @author povilas
     * @see EntitySprite#setPosition(Vector2)
     */
    @Test
    public void testSetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            Vector2 position = mock(Vector2.class);
            underTest.setPosition(position);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

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
            Supplier<EntitySprite> spriteSupplier = mock(Supplier.class);
            SpriteFunction underTest = new SpriteFunction(spriteSupplier);

            // When
            double y = 0.0d; // UTA: default value
            underTest.setTranslateY(y);

        });
    }
}