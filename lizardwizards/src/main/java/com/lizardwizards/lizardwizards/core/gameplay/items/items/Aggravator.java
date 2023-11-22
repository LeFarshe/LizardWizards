package com.lizardwizards.lizardwizards.core.gameplay.items.items;

import com.lizardwizards.lizardwizards.client.sprites.RectangleSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import com.lizardwizards.lizardwizards.core.gameplay.items.Item;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;

public class Aggravator extends Item {
    double speedMultiplier = 2;
    double durationMultiplier = 0.3;
    public Aggravator() {
        super(new RectangleSprite(new Vector2(0,0), new Vector2(10,10)), new Vector2(10,10));
    }

    @Override
    public void collect(Player player) {
        IWeapon currentWeapon = player.getCurrentWeapon();
        currentWeapon.setShotSpeed(currentWeapon.getShotSpeed() * speedMultiplier);
        currentWeapon.setShotDuration(currentWeapon.getShotDuration() * durationMultiplier);
    }
}
