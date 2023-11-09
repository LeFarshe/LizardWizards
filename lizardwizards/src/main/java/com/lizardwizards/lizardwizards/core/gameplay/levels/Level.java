package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.Vector2;

public class Level {
    RoomData[][] rooms;
    int size;
    Vector2 currentPos;
    // 0 is center, 1 is up, continues clockwise until 4 which means left.
    public int enteredDirection = 0;

    public Level(RoomData[][] rooms, int size){
        this.rooms = rooms;
        this.size = size;
        int startPos = (size - 1) / 2;
        currentPos = new Vector2(startPos, startPos);
    }

    public RoomData getCurrentRoom(){
        return rooms[(int)currentPos.x][(int)currentPos.y];
    }

    public boolean[] getDoors(){
        boolean[] enterableDirections = new boolean[4];
        Vector2 newPos;

        for (int i = 0; i < 4; i++){
            enterableDirections[i] = canMove(directionalPosition(i + 1));
        }

        return enterableDirections;
    }

    public boolean moveDirectionally(int direction){
        Vector2 newPos = directionalPosition(direction);
        enteredDirection = (direction + 2) % 4;
        if (enteredDirection == 0) { enteredDirection = 4; }
        return teleport(newPos, enteredDirection);
    }

    public boolean teleport(Vector2 position, int whichDoor){
        if (canMove(position)) {
            currentPos = position.Copy();
            enteredDirection = whichDoor;
            return true;
        }
        return false;
    }

    public boolean canMove(Vector2 position){
        if (position.x >= size || position.x < 0 || position.y >= size || position.y < 0 || rooms[(int)position.x][(int)position.y] == null)
        {
            return false;
        }
        return true;
    }

    private Vector2 directionalPosition(int direction){
        Vector2 newPos = currentPos.Copy();
        if (direction % 2 == 1) {
            newPos.x += (direction - 2);
        }
        else {
            newPos.y += (direction - 3) * (-1);
        }
        return newPos;
    }
}
