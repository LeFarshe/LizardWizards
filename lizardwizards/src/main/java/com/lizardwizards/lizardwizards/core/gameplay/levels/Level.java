package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.Vector2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Level implements Iterable<Vector2> {
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
        return !(position.x >= size) && !(position.x < 0) && !(position.y >= size) && !(position.y < 0) && rooms[(int) position.x][(int) position.y] != null;
    }

    public RoomData getRoom(Vector2 position) {
        if (!canMove(position))
            return null;
        return rooms[(int)position.x][(int)position.y];
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

    @Override
    public Iterator<Vector2> iterator() {
        List<Vector2> possible = new ArrayList<>();
        for (int x = 0; x < size; x++){
            for (int y = 0; y < size; y++){
                Vector2 newPos = new Vector2(x,y);
                if (canMove(newPos)) { possible.add(newPos);}
            }
        }
        
        return possible.iterator();
    }

    @Override
    public void forEach(Consumer<? super Vector2> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Vector2> spliterator() {
        return Iterable.super.spliterator();
    }
}
