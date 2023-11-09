package com.lizardwizards.lizardwizards.core.gameplay.levels;

import java.util.ArrayList;
import java.util.List;

public class LevelDirector {
    List<GenerationRoomData> startRooms = new ArrayList<>();
    List<GenerationRoomData> basicRooms = new ArrayList<>();

    public LevelDirector() {
        //START ROOMS
        RoomData startData = new RoomData(RoomEnumerator.Start);
        GenerationRoomData startRoom = new GenerationRoomData(startData, 1, new boolean[] {true, true, true, true});
        startRooms.add(startRoom);

        //NORMAL ROOMS
        RoomData basicRoomData = new RoomData(RoomEnumerator.BasicRoom);
        GenerationRoomData basicRoom = new GenerationRoomData(basicRoomData, 1, new boolean[] {true, true, true, true});
        basicRooms.add(basicRoom);
    }
    public Level testLevel(LevelBuilder builder){
        builder.reset();
        builder.createLevelStructure(10, 3, 0.5);
        builder.setStartRoom(startRooms);
        builder.setNonSpecialRooms(basicRooms);
        builder.setDeadEnds(basicRooms);
        return builder.build();
    }


}
