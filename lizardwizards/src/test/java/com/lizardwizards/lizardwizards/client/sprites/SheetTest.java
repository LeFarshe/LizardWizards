package com.lizardwizards.lizardwizards.client.sprites;


import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Sheet
 *
 * @see Sheet
 * @author povilas
 */
public class SheetTest
{
    /**
     * Parasoft Jtest UTA: Test for add(EntitySprite)
     *
     * @author povilas
     * @see Sheet#add(EntitySprite)
     */
    @Test
    public void testAdd() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Sheet underTest = new Sheet();

            // When
            EntitySprite entitySprite = mock(EntitySprite.class);
            boolean result = underTest.add(entitySprite);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getList()
     *
     * @author povilas
     * @see Sheet#getList()
     */
    @Test
    public void testGetList() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Sheet underTest = new Sheet();

            // When
            List<EntitySprite> result = underTest.getList();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for hasNext()
     *
     * @author povilas
     * @see Sheet#hasNext()
     */
    @Test
    public void testHasNext() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Sheet underTest = new Sheet();

            // When
            boolean result = underTest.hasNext();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for next()
     *
     * @author povilas
     * @see Sheet#next()
     */
    @Test
    public void testNext() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Sheet underTest = new Sheet();

            // When
            EntitySprite result = underTest.next();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for remove(EntitySprite)
     *
     * @author povilas
     * @see Sheet#remove(EntitySprite)
     */
    @Test
    public void testRemove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Sheet underTest = new Sheet();
            underTest.current = mock();

            // When
            EntitySprite entitySprite = mock(EntitySprite.class);
            boolean result = underTest.remove(entitySprite);

        });
    }
}