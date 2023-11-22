package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;

public class ExistingItem {
    Vector2 position;
    Item item;
    public ExistingItem(Item item, Vector2 position){
        this.item = item;
        this.position = position;
    }
}
