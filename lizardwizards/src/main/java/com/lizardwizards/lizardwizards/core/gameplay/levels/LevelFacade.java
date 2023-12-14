package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.DefaultEnemyFactory;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;

public class LevelFacade {
    private LevelDirector levelDirector;
    private RoomFactory roomFactory;

    private LevelBuilder levelBuilder;
    private DefaultEnemyFactory enemyFactory;
    private WeaponUpgradeFactory weaponUpgradeFactory;


    public LevelFacade() {
        levelBuilder = new LevelBuilder(11);
        levelDirector = new LevelDirector();

        enemyFactory = new DefaultEnemyFactory();
        roomFactory = new RoomFactory();
        weaponUpgradeFactory = new WeaponUpgradeFactory();
    }

    public Level getLevel(int level){
        return levelDirector.getLevel(levelBuilder, weaponUpgradeFactory, level);
    }

    public RoomInformation getRoom(Level level){
        return roomFactory.getRoom(level, enemyFactory);
    }
}
