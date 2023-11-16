package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.*;

public class LevelBuilder {
    RoomData[][] rooms;
    int size;
    int[][] levelStructure;
    List<Vector2> deadEnds;
    static Random random = new Random();

    public LevelBuilder(int size){
        this.size = size;
    }

    public void reset(){
        rooms = null;
        levelStructure = null;
        deadEnds = null;
    }

    public Level build(){
        return new Level(rooms, size);
    }

    public void createLevelStructure(int rooms, int deadEndMin, double randomFail){
        while (!isStructureGood(rooms, deadEndMin)){
            levelStructurePart(rooms, randomFail);
        }
        this.rooms = new RoomData[size][size];
    }

    public void setStartRoom(List<GenerationRoomData> startRooms){
        int startPos = (size - 1) / 2;
        Vector2 start = new Vector2(startPos, startPos);
        setRoomRandom(start, startRooms);
        rooms[startPos][startPos].cleared = true;
    }

    public void setNonSpecialRooms(List<GenerationRoomData> roomList) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++){
                if (levelStructure[x][y] == 1) {
                    setRoomRandom(new Vector2(x,y), roomList);
                }
            }
        }
    }

    public void setDeadEnds(List<GenerationRoomData> roomList) {
        for (Vector2 deadEnd: deadEnds) {
            setRoomRandom(deadEnd, roomList);
        }
    }

    public void setRoomRandom(Vector2 position, List<GenerationRoomData> allRooms){
        List<GenerationRoomData> possibleRooms = new ArrayList<>();
        double allRoomProbability = 0;

        for (GenerationRoomData room: allRooms){
            if (roomFits(room, position)){
                possibleRooms.add(room);
                allRoomProbability += room.probability;
            }
        }

        double roomChosen = random.nextDouble() * allRoomProbability;

        for (GenerationRoomData room: possibleRooms){
            roomChosen -= room.probability;
            if (roomChosen <= 0) {
                setRoom(position, room.roomData);
                break;
            }
        }
    }

    public void setRoom(Vector2 position, RoomData room){
        rooms[(int)position.x][(int)position.y] = room.clone();
    }

    private boolean roomFits(GenerationRoomData room, Vector2 position){
        if (!room.up && getRoomValue(new Vector2(position.x - 1, position.y)) != 0) { return false; }
        if (!room.down && getRoomValue(new Vector2(position.x + 1, position.y)) != 0) { return false; }
        if (!room.left && getRoomValue(new Vector2(position.x, position.y - 1)) != 0) { return false; }
        if (!room.right && getRoomValue(new Vector2(position.x, position.y + 1)) != 0) { return false; }
        return true;
    }

    private boolean isStructureGood(int rooms, int deadEndMin){
        if (levelStructure == null) { return false; }
        if (deadEnds.size() < deadEndMin) { return false;}
        int roomCount = 0;

        for (int x = 0; x < size; x++){
            for (int y = 0; y < size; y++) {
                if (levelStructure[x][y] != 0) { roomCount ++; }
            }
        }
         return roomCount == rooms;
    }

    private void levelStructurePart(int rooms, double randomFail){
        levelStructure = new int[size][size];
        deadEnds = new ArrayList<>();

        int startPos = (size - 1) / 2;

        levelStructure[startPos][startPos] = 3;
        rooms--;

        Queue<Vector2> roomIterationList = new LinkedList<>();
        roomIterationList.add(new Vector2(startPos, startPos));

        while (!roomIterationList.isEmpty()){
            Vector2 currentPos = roomIterationList.remove();

            if (rooms == 0) {
                setRoomValue(currentPos, 2);
                deadEnds.add(currentPos);
                continue;
            }

            int newRooms = 0;

            for (Vector2 newPos : getNearby(currentPos)){
                if (canGenerate(newPos)) {
                    if (random.nextDouble() >= randomFail && rooms > 0) {
                        roomIterationList.add(newPos);
                        setRoomValue(newPos, 1);

                        rooms--;
                        newRooms++;
                    }
                }
            }

            if (newRooms == 0) {
                setRoomValue(currentPos, 2);
                deadEnds.add(currentPos);
            }
        }
    }

    private List<Vector2> getNearby(Vector2 position){
        List<Vector2> possible = new ArrayList<>();

        if (position.x > 0){
            possible.add(new Vector2(position.x - 1, position.y));
        }
        if (position.x < size - 1){
            possible.add(new Vector2(position.x + 1, position.y));
        }

        if (position.y > 0){
            possible.add(new Vector2(position.x , position.y - 1));
        }
        if (position.y < size - 1){
            possible.add(new Vector2(position.x, position.y + 1));
        }

        return possible;
    }

    private boolean canGenerate(Vector2 position){
        if (getRoomValue(position) != 0) { return false;}

        List<Vector2> neighbourList = getNearby(position);
        int neighbourCount = 0;
        for (Vector2 pos: neighbourList){
            if (getRoomValue(pos) != 0) { neighbourCount += 1; }
        }

        if (neighbourCount > 1) { return false; }
        return true;
    }

    private int getRoomValue(Vector2 position){
        if (position.x < 0 || position.y < 0 || position.x >= size || position.y >= size) { return 0; }
        return levelStructure[(int)position.x][(int)position.y];
    }

    private void setRoomValue(Vector2 position, int value) {
        levelStructure[(int)position.x][(int)position.y] = value;
    }


}
