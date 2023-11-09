package com.lizardwizards.lizardwizards.core.gameplay;

public class GenerationRoomData {
    RoomData roomData;

    // 1 should be default
    double probability;

    // Can the side have a door
    boolean up, right, down, left;

    public GenerationRoomData(RoomData roomData, double probability, boolean[] directions){
        this.roomData = roomData;
        this.probability = probability;
        up = directions[0];
        right = directions[1];
        down = directions[2];
        left = directions[3];
    }
}
