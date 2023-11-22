package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;

import java.util.ArrayList;
import java.util.List;

public class RoomData implements Cloneable{
    RoomEnumerator id;
    boolean cleared;
    List<ExistingItem> itemList = new ArrayList<>();

    public RoomData(RoomEnumerator id){
        this.id = id;
    }
    public void setCleared() { cleared = true;}
    public void addItem(Item item, Vector2 position){
        itemList.add(new ExistingItem(item, position));
    }



    @Override
    public RoomData clone() {
        try {
            RoomData clone = (RoomData) super.clone();
            clone.cleared = cleared;
            clone.id = id;
            clone.itemList = new ArrayList<>();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
