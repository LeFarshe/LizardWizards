package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.BigBugEnemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.StandardEnemy;
import com.lizardwizards.lizardwizards.core.gameplay.items.ItemHolder;
import com.lizardwizards.lizardwizards.core.gameplay.items.items.WeaponUpgradeItem;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrades;
import com.lizardwizards.lizardwizards.core.gameplay.levels.RoomFactory;

import java.util.Arrays;

public enum ServerCommands {
    START_SERVER ("startServer"){
        @Override
        public void execute(String... args){
            LizardWizardsServer.startServer();
        }
    },
    SPAWN_MOB ("mob") {
        @Override
        public void execute(String... args) {
            EntityWrapper ew;
            Vector2 pos = new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax / 2);
            switch (args[0]) {
                case "1" -> {
                    var enemy = new BigBugEnemy(pos);
                    var sprite = enemy.getSprite();
                    var w = sprite.getWidth();
                    var h = sprite.getHeight();
                    Collider collider = Collider.NewRectangle(pos, w, h, CollisionLayer.Enemy);
                    ew = new EntityWrapper(enemy, enemy.getSprite(), collider);
                }
                default -> {
                    var enemy = new StandardEnemy(pos);
                    var sprite = enemy.getSprite();
                    var w = sprite.getWidth();
                    var h = sprite.getHeight();
                    Collider collider = Collider.NewRectangle(pos, w, h, CollisionLayer.Enemy);
                    ew = new EntityWrapper(enemy, enemy.getSprite(), collider);
                }
            }
            ServerTimer.addNewEntity(ew, ew.entity.uuid);
        }
    },
    SPAWN_ITEM ("item") {
        @Override
        public void execute(String... args) {
            Vector2 pos = new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax / 2);
            for (var upgrade : WeaponUpgrades.values()) {
                if (upgrade.name().compareToIgnoreCase(args[0]) == 0) {
                    var upgradeFactory = new WeaponUpgradeFactory();
                    var weaponUpgrade = upgradeFactory.getUpgrade(upgrade);
                    var item = new WeaponUpgradeItem(weaponUpgrade);
                    ItemHolder itemHolder = new ItemHolder(pos, item);
                    EntitySprite sprite = item.getSprite();
                    Collider collider = Collider.NewRectangle(pos, item.getSize().x, item.getSize().y, CollisionLayer.Item);
                    EntityWrapper ew = new EntityWrapper(itemHolder, sprite, collider);
                    ServerTimer.addNewEntity(ew, ew.entity.uuid);
                    return;
                }
            }
            System.out.println("Could not find item " + args[0]);
        }
    },
    NOT_FOUND ("") { // Has to be last in list
        @Override
        public boolean checkMatch(String command) {
            this.command = command;
            return true;
        }
    },
    ;

    String command;
    ServerCommands(String command) {
        this.command = command;
    }

    public boolean checkMatch(String command) {
        return command.compareTo(this.command) == 0;
    }

    public void execute(String... args) {
        System.out.println("Could not find command " + this.command);
    }
}
