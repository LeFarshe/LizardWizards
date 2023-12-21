package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;

public class LevelFacade {
    private final LevelDirector levelDirector;
    private final RoomFactory roomFactory;

    private final LevelBuilder levelBuilder;
    private final WeaponUpgradeFactory weaponUpgradeFactory;


    public LevelFacade() {
        levelBuilder = new LevelBuilder(11);
        levelDirector = new LevelDirector();
        roomFactory = new RoomFactory();
        weaponUpgradeFactory = new WeaponUpgradeFactory();
    }

    public Level getLevel(int level){
        return levelDirector.getLevel(levelBuilder, weaponUpgradeFactory, level);
    }

    public Level getCustomLevel(int rooms, int deadEnds, double randomFail){
        return levelDirector.createLevel(levelBuilder, rooms, deadEnds, randomFail);
    }

    public RoomInformation getRoom(Level level){
        return roomFactory.getRoom(level);
    }
}