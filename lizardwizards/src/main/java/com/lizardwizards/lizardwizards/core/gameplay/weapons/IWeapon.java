package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;

import java.io.Serializable;
import java.util.List;

public interface IWeapon extends Cloneable, Serializable {
    double getDamage();
    double getFireRate();
    void setFireRate(double fireRate);
    ImageSprite getHudIcon();
    List<IProjectile> Shoot(Vector2 direction, Vector2 position);
    List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position);
    List<IProjectile> AddTimeWithoutShoot(double delta);
    public IWeapon clone();
}
