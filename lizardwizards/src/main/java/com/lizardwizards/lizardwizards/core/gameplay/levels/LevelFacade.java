package com.lizardwizards.lizardwizards.core.gameplay.levels;

import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.DefaultEnemyFactory;

public class LevelFacade {
    private LevelDirector levelDirector;
    private RoomFactory roomFactory;

    private LevelBuilder levelBuilder;
    private DefaultEnemyFactory enemyFactory;


    public LevelFacade() {
        levelBuilder = new LevelBuilder(11);
        levelDirector = new LevelDirector();

        enemyFactory = new DefaultEnemyFactory();
        roomFactory = new RoomFactory();
    }

    public Level getLevel(String levelName){
        if (levelName.equalsIgnoreCase("Level1")){
            return levelDirector.testLevel(levelBuilder);
        }
        return null;
    }

    public RoomInformation getRoom(Level level){
        return roomFactory.getRoom(level, enemyFactory);
    }
}
