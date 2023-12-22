package com.lizardwizards.lizardwizards.core.gameplay.levels;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.server.LizardWizardsServer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for LevelBuilder
 *
 * @see LevelBuilder
 * @author povilas
 */
public class LevelBuilderTest
{
    /**
     * Parasoft Jtest UTA: Test for build()
     *
     * @author povilas
     * @see LevelBuilder#build()
     */
    @Test
    public void testBuild() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);

            // When
            Level result = underTest.build();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for createLevelStructure(int, int, double)
     *
     * @author povilas
     * @see LevelBuilder#createLevelStructure(int, int, double)
     */
    @Test
    public void testCreateLevelStructure() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);

            // When
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for reset()
     *
     * @author povilas
     * @see LevelBuilder#reset()
     */
    @Test
    public void testReset() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);

            // When
            underTest.reset();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setBossRoom(List)
     *
     * @author povilas
     * @see LevelBuilder#setBossRoom(List)
     */
    @Test
    public void testSetBossRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            List<GenerationRoomData> roomList = new ArrayList<GenerationRoomData>(); // UTA: default value
            RoomData startData = new RoomData(RoomEnumerator.Start);
            GenerationRoomData item = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
            roomList.add(item);
            underTest.setBossRoom(roomList);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setDeadEnds(List)
     *
     * @author povilas
     * @see LevelBuilder#setDeadEnds(List)
     */
    @Test
    public void testSetDeadEnds() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            List<GenerationRoomData> roomList = new ArrayList<GenerationRoomData>(); // UTA: default value
            RoomData startData = new RoomData(RoomEnumerator.Start);
            GenerationRoomData item = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
            roomList.add(item);
            underTest.setDeadEnds(roomList);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setNonSpecialRooms(List)
     *
     * @author povilas
     * @see LevelBuilder#setNonSpecialRooms(List)
     */
    @Test
    public void testSetNonSpecialRooms() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            List<GenerationRoomData> roomList = new ArrayList<GenerationRoomData>(); // UTA: default value
            GenerationRoomData item = mock(GenerationRoomData.class);
            roomList.add(item);
            underTest.setNonSpecialRooms(roomList);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setRandomTreasureRoom(List, WeaponUpgradeFactory)
     *
     * @author povilas
     * @see LevelBuilder#setRandomTreasureRoom(List, WeaponUpgradeFactory)
     */
    @Test
    public void testSetRandomTreasureRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.
        LizardWizardsServer.isRunning = true;

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            List<GenerationRoomData> roomList = new ArrayList<GenerationRoomData>(); // UTA: default value
            RoomData startData = new RoomData(RoomEnumerator.Start);
            GenerationRoomData item = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
            roomList.add(item);
            WeaponUpgradeFactory weaponUpgradeFactory = new WeaponUpgradeFactory();
            underTest.setRandomTreasureRoom(roomList, weaponUpgradeFactory);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setRoom(Vector2, RoomData)
     *
     * @author povilas
     * @see LevelBuilder#setRoom(Vector2, RoomData)
     */
    @Test
    public void testSetRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            Vector2 position = mock(Vector2.class);
            RoomData room = mock(RoomData.class);
            underTest.setRoom(position, room);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setRoomRandom(Vector2, List)
     *
     * @author povilas
     * @see LevelBuilder#setRoomRandom(Vector2, List)
     */
    @Test
    public void testSetRoomRandom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            Vector2 position = new Vector2(0, 0);
            List<GenerationRoomData> allRooms = new ArrayList<GenerationRoomData>(); // UTA: default value
            RoomData startData = new RoomData(RoomEnumerator.Start);
            GenerationRoomData item = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
            allRooms.add(item);
            underTest.setRoomRandom(position, allRooms);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for setStartRoom(List)
     *
     * @author povilas
     * @see LevelBuilder#setStartRoom(List)
     */
    @Test
    public void testSetStartRoom() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            int size = 1; // UTA: default value
            LevelBuilder underTest = new LevelBuilder(size);
            int rooms = 1; // UTA: default value
            int deadEndMin = 1; // UTA: default value
            double randomFail = 0.5d; // UTA: default value
            underTest.createLevelStructure(rooms, deadEndMin, randomFail);

            // When
            List<GenerationRoomData> startRooms = new ArrayList<GenerationRoomData>(); // UTA: default value
            RoomData startData = new RoomData(RoomEnumerator.Start);
            GenerationRoomData item = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
            startRooms.add(item);
            underTest.setStartRoom(startRooms);

        });
    }
}