package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.communication.RoomInformation;
import com.lizardwizards.lizardwizards.core.gameplay.EntityWrapper;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.BigBugEnemy;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemies;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.StandardEnemy;
import com.lizardwizards.lizardwizards.core.gameplay.items.ItemHolder;
import com.lizardwizards.lizardwizards.core.gameplay.items.items.WeaponUpgradeItem;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrade;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrades;
import com.lizardwizards.lizardwizards.core.gameplay.levels.RoomEnumerator;

import java.util.Arrays;
import java.util.Iterator;

public enum ServerCommands {
    HELP ("help", "Prints information about server commands") {
        @Override
        public void execute(String... args) {
            for (var command : ServerCommands.values()) {
                var desc = command.description;
                if (desc != null) {
                    System.out.printf("%s - %s\n", command.command, desc);
                }
            }
        }
    },
    START_SERVER ("startServer", "Starts a new server with the next available port"){

        @Override
        public void execute(String... args){
            LizardWizardsServer.startServer();
        }
    },
    SPAWN_MOB ("mob", "(mob <mob id>) Spawns the selected monster") {

        @Override
        public void execute(String... args) {
            if (args.length != 1) {
                System.out.println("Available options: " + Arrays.toString(Enemies.values()));
                return;
            }
            Vector2 pos = new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax / 2);
            for (var enemy : Enemies.values()) {
                if (enemy.name().compareToIgnoreCase(args[0]) == 0) {
                    EntityWrapper ew = enemy.getEntityWrapper(pos);
                    ServerTimer.addNewEntity(ew, ew.entity.uuid);
                    return;
                }
            }
            System.out.println("Could not find enemy " + args[0]);
        }
    },
    SPAWN_ITEM ("item", "(item <item name>) Spawns the selected item") {
        @Override
        public void execute(String... args) {
            if (args.length != 1) {
                System.out.println("Available options: " + Arrays.toString(WeaponUpgrades.values()));
                return;
            }
            Vector2 pos = new Vector2(RoomInformation.xMax / 2, RoomInformation.yMax / 2);
            for (var upgrade : WeaponUpgrades.values()) {
                if (upgrade.name().compareToIgnoreCase(args[0]) == 0) {
                    var upgradeFactory = new WeaponUpgradeFactory();
                    var weaponUpgrade = upgradeFactory.getUpgrade(upgrade);
                    var item = new WeaponUpgradeItem(weaponUpgrade);
                    ItemHolder itemHolder = new ItemHolder(pos, item); //TODO: same as above
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
    TELEPORT_TO_ROOM ("goto", "(goto <room type> Teleports the players to the specified room type if it can be found") {
        @Override
        public void execute(String... args) {
            if (args.length != 1) {
                System.out.println("Available options: " + Arrays.toString(RoomEnumerator.values()));
                return;
            }

            for (var roomType : RoomEnumerator.values()) {
                if (roomType.name().compareToIgnoreCase(args[0]) == 0) {

                    var level = ServerTimer.currentLevel;
                    Vector2 lastAlmostMatch = null;
                    for (Vector2 room : level) {
                        var roomData = level.getRoom(room);
                        if (roomData.getRoomID() == roomType) {
                            if (!roomData.isCleared()) {
                                level.teleport(room,0);
                                Server.serverTimer.loadRoom();
                                System.out.println("Teleporting");
                                return;
                            }
                            lastAlmostMatch = room;
                        }
                    }
                    if (lastAlmostMatch != null){
                        level.teleport(lastAlmostMatch,0);
                        Server.serverTimer.loadRoom();
                        System.out.println("Teleporting");
                        return;
                    }
                    System.out.println("Could not find room " + args[0] + " in current level");
                    return;
                }
            }
            System.out.println("Could not find room type " + args[0]);

        }
    },
    NOT_FOUND ("", null) { // Has to be last defined enumerator
        @Override
        public boolean checkMatch(String command) {
            this.command = command;
            return true;
        }
    },
    ;

    String command;
    final String description;
    ServerCommands(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public boolean checkMatch(String command) {
        return command.compareTo(this.command) == 0;
    }

    public void execute(String... args) {
        System.out.println("Could not find command " + this.command);
    }
}
