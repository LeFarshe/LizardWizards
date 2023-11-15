package com.lizardwizards.lizardwizards.core.gameplay.levels;

public class RoomData implements Cloneable{
    RoomEnumerator id;
    boolean cleared;

    public RoomData(RoomEnumerator id){
        this.id = id;
    }
    public void setCleared() { cleared = true;}

    @Override
    public RoomData clone() {
        try {
            RoomData clone = (RoomData) super.clone();
            clone.cleared = cleared;
            clone.id = id;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
