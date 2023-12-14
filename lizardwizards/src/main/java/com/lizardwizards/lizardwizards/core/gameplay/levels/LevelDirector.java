package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;

import java.util.ArrayList;
import java.util.List;

public class LevelDirector {
    List<GenerationRoomData> startRooms = new ArrayList<>();
    List<GenerationRoomData> basicRooms = new ArrayList<>();
    List<GenerationRoomData> bossRooms = new ArrayList<>();

    public LevelDirector() {
        //START ROOMS
        RoomData startData = new RoomData(RoomEnumerator.Start);
        GenerationRoomData startRoom = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
        startRooms.add(startRoom);

        //NORMAL ROOMS
        RoomData basicRoomData = new RoomData(RoomEnumerator.BasicRoom);
        GenerationRoomData basicRoom = new GenerationRoomData(basicRoomData, 1, new boolean[] {true, true, true, true});
        basicRooms.add(basicRoom);

        RoomData basicRoomData2 = new RoomData(RoomEnumerator.BasicRoom2);
        GenerationRoomData basicRoom2 = new GenerationRoomData(basicRoomData2, 1, new boolean[] {true, true, true, true});
        basicRooms.add(basicRoom2);

        // BOSS ROOMS
        RoomData bossRoomData = new RoomData(RoomEnumerator.BossRoom);
        GenerationRoomData bossRoom = new GenerationRoomData(bossRoomData, 1, new boolean[] {true, true, true, true});
        bossRooms.add(bossRoom);
    }
    public Level getLevel(LevelBuilder builder, WeaponUpgradeFactory weaponUpgradeFactory, int level){
        builder.reset();
        int roomCount = 7 + 3 * level;
        if (roomCount > 50){
            roomCount = 50;
        }
        builder.createLevelStructure(roomCount, 3, 0.5);
        builder.setStartRoom(startRooms);
        builder.setNonSpecialRooms(basicRooms);
        builder.setBossRoom(bossRooms);
        builder.setRandomTreasureRoom(startRooms, weaponUpgradeFactory);
        builder.setRandomTreasureRoom(startRooms, weaponUpgradeFactory);
        builder.setDeadEnds(basicRooms);
        Level builtLevel = builder.build();
        builtLevel.setLevel(level);
        return builtLevel;
    }


}
