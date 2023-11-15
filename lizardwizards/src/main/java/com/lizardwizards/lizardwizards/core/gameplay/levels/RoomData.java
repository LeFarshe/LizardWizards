package com.lizardwizards.lizardwizards.core.gameplay.levels;

public class RoomData {
    RoomEnumerator id;
    boolean cleared;

    public RoomData(RoomEnumerator id){
        this.id = id;
    }
    public void setCleared() { cleared = true;}
}
