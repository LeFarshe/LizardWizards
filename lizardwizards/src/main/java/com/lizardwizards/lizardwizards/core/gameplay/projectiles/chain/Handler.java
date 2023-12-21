package com.lizardwizards.lizardwizards.core.gameplay.projectiles.chain;

public interface Handler {
    void setNext(Handler handler);
    void handle();
    boolean toBeRemoved();

}
