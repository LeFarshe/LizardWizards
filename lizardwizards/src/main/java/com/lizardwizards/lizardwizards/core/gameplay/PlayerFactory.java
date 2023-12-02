package com.lizardwizards.lizardwizards.core.gameplay;

import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.WeaponFactory;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.WeaponTypes;

import java.util.LinkedList;
import java.util.List;

public class PlayerFactory {
    private static final WeaponFactory weaponFactory = new WeaponFactory();
    private static final LinkedList<SpriteColor> playerColors = new LinkedList<>(List.of(
            new SpriteColor(0.3, 1, 0.3),
            new SpriteColor(1, 0.3, 1),
            new SpriteColor(0.3, 0.5, 1),
            new SpriteColor(1, 0.8, 0.3)));
    private static int playersCreated = 0;

    public static EntityWrapper getPlayer(PlayerClass playerClass) {
        Player player = new Player(new Vector2(0,0), 400);
        Collider collider = Collider.NewRectangle(new Vector2(0, 0), 20, 20, CollisionLayer.Player);
        var playerColor = playerColors.get(playersCreated % playerColors.size());
        RectangleSprite playerSprite = new RectangleSprite(new Vector2(0,0), new Vector2(20,20), playerColor);

        switch (playerClass) {
            case Blizzard -> {
                playersCreated ++;
                player.weapons.add(weaponFactory.getWeapon(WeaponTypes.ViolentWand));
                player.weapons.add(weaponFactory.getWeapon(WeaponTypes.WardWand));
                return new EntityWrapper(player, playerSprite, collider);
            }
            case Richard -> {
                playersCreated ++;
                player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Pistol));
                player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Shotgun));
                player.weapons.add(weaponFactory.getWeapon(WeaponTypes.Chaingun));
                return new EntityWrapper(player, playerSprite, collider);
            }
            default -> {
                return null;
            }
        }
    }
}
