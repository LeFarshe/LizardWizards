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
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgradeFactory;
import com.lizardwizards.lizardwizards.core.gameplay.items.weaponUpgrades.WeaponUpgrades;

public enum ServerCommands {
    HELP ("help") {
        @Override
        public String description() {
            return "Prints information about server commands";
        }

        @Override
        public void execute(String... args) {
            for (var command : ServerCommands.values()) {
                var desc = command.description();
                if (desc != null) {
                    System.out.printf("%s - %s\n", command.command, desc);
                }
            }
        }
    },
    START_SERVER ("startServer"){
        @Override
        public String description() {
            return "Starts a new server with the next available port";
        }

        @Override
        public void execute(String... args){
            LizardWizardsServer.startServer();
        }
    },
    SPAWN_MOB ("mob") {
        @Override
        public String description() {
            return "(mob <mob id>) Spawns the selected monster";
        }

        @Override
        public void execute(String... args) {
            if (args.length < 1) {
                System.out.println(description());
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
    SPAWN_ITEM ("item") {
        @Override
        public String description() {
            return "(item <item name>) Spawns the selected item";
        }

        @Override
        public void execute(String... args) {
            if (args.length < 1) {
                System.out.println(description());
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
    // Teleporting to specific rooms could be nice, but don't want to fuck with Level right now
    NOT_FOUND ("") { // Has to be last defined enumerator
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
    public String description() {
        return null;
    }
}
