package com.lizardwizards.lizardwizards.client.sprites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sheet implements Serializable, Iterator<EntitySprite>{

    Node current;
    int size = 0;

    static class Node implements Serializable{
        EntitySprite data;
        Node next;
        Node prev;

        Node(EntitySprite entitySprite) {
            data = entitySprite;
            next = null;
            prev = null;
        }
    }

    public boolean add(EntitySprite entitySprite){
        if (entitySprite == null){
            return false;
        }
        else if (size == 0){
            current = new Node(entitySprite);
            current.next = current;
            current.prev = current;
            size++;
            return true;
        }
        else {
            Node addition = new Node(entitySprite);
            current.prev.next = addition;
            addition.prev = current.prev;
            addition.next = current;
            current.prev = addition;
            size++;
            return true;
        }
    }

    public boolean remove(EntitySprite entitySprite){
        boolean flag = false;
        Node current = this.current;
        for (int i = 0; i <= size; i++){
            if(current.data == entitySprite){
                if (size == 1){
                    this.current = null;
                }
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                flag = true;
                break;
            }
            current = current.next;
        }
        return flag;
    }

    public List<EntitySprite> getList(){
        List<EntitySprite> data = new ArrayList<EntitySprite>();
        for (int i = 0; i <= size; i++){
            data.add(this.next());
        }
        return data;
    }


    @Override
    public boolean hasNext() {
                return current != null;
            }
    @Override
    public EntitySprite next() {
        if (hasNext()) {
            EntitySprite data = current.data;
            current = current.next;
            return data;
        }
        return null;
    }

    /**
     * Don't fucking use it, it will break everything
     */
    @Override
    public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

}
