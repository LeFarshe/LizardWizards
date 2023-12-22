package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.Vector2;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for Level
 *
 * @see Level
 * @author povilas
 */
public class LevelTest
{
    /**
     * Parasoft Jtest UTA: Test for canMove(Vector2)
     *
     * @author povilas
     * @see Level#canMove(Vector2)
     */
    @Test
    public void testCanMove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Vector2 position = mock(Vector2.class);
            boolean result = underTest.canMove(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for forEach(Consumer)
     *
     * @author povilas
     * @see Level#forEach(Consumer)
     */
    @Test
    public void testForEach() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Consumer action = mock(Consumer.class);
            underTest.forEach(action);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getCurrentRoom()
     *
     * @author povilas
     * @see Level#getCurrentRoom()
     */
    @Test
    public void testGetCurrentRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[1][1]; // UTA: default value
            int size = 1; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            RoomData result = underTest.getCurrentRoom();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getDoors()
     *
     * @author povilas
     * @see Level#getDoors()
     */
    @Test
    public void testGetDoors() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            boolean[] result = underTest.getDoors();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getRoom(Vector2)
     *
     * @author povilas
     * @see Level#getRoom(Vector2)
     */
    @Test
    public void testGetRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Vector2 position = mock(Vector2.class);
            RoomData result = underTest.getRoom(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for iterator()
     *
     * @author povilas
     * @see Level#iterator()
     */
    @Test
    public void testIterator() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Iterator<Vector2> result = underTest.iterator();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for moveDirectionally(int)
     *
     * @author povilas
     * @see Level#moveDirectionally(int)
     */
    @Test
    public void testMoveDirectionally() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            int direction = 0; // UTA: default value
            boolean result = underTest.moveDirectionally(direction);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setLevel(int)
     *
     * @author povilas
     * @see Level#setLevel(int)
     */
    @Test
    public void testSetLevel() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            int level = 0; // UTA: default value
            underTest.setLevel(level);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for spliterator()
     *
     * @author povilas
     * @see Level#spliterator()
     */
    @Test
    public void testSpliterator() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Spliterator<Vector2> result = underTest.spliterator();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for teleport(Vector2, int)
     *
     * @author povilas
     * @see Level#teleport(Vector2, int)
     */
    @Test
    public void testTeleport() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            RoomData[][] rooms = new com.lizardwizards.lizardwizards.core.gameplay.levels.RoomData[0][]; // UTA: default value
            int size = 0; // UTA: default value
            Level underTest = new Level(rooms, size);

            // When
            Vector2 position = mock(Vector2.class);
            int whichDoor = 0; // UTA: default value
            boolean result = underTest.teleport(position, whichDoor);

        });
    }
}