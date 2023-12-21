package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for RoomData
 *
 * @see RoomData
 * @author povilas
 */
public class RoomDataTest
{
    /**
     * Parasoft Jtest UTA: Test for addItem(Item, Vector2)
     *
     * @author povilas
     * @see RoomData#addItem(Item, Vector2)
     */
    @Test
    public void testAddItem() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            Item item = mock(Item.class);
            Vector2 position = mock(Vector2.class);
            underTest.addItem(item, position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getRoomID()
     *
     * @author povilas
     * @see RoomData#getRoomID()
     */
    @Test
    public void testGetRoomID() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            RoomEnumerator result = underTest.getRoomID();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for isBossRoom()
     *
     * @author povilas
     * @see RoomData#isBossRoom()
     */
    @Test
    public void testIsBossRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            boolean result = underTest.isBossRoom();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for isCleared()
     *
     * @author povilas
     * @see RoomData#isCleared()
     */
    @Test
    public void testIsCleared() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            boolean result = underTest.isCleared();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for removeItem(Item)
     *
     * @author povilas
     * @see RoomData#removeItem(Item)
     */
    @Test
    public void testRemoveItem() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            Item item = mock(Item.class);
            underTest.removeItem(item);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setBossRoom()
     *
     * @author povilas
     * @see RoomData#setBossRoom()
     */
    @Test
    public void testSetBossRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            underTest.setBossRoom();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setCleared()
     *
     * @author povilas
     * @see RoomData#setCleared()
     */
    @Test
    public void testSetCleared() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomEnumerator id = RoomEnumerator.BasicRoom; // UTA: default value
            RoomData underTest = new RoomData(id);

            // When
            underTest.setCleared();

        });
    }
}