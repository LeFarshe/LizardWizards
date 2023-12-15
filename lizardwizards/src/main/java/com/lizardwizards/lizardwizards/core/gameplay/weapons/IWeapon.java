package com.lizardwizards.lizardwizards.core.gameplay.weapons;

import com.lizardwizards.lizardwizards.client.sprites.ImageSprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;

import java.io.Serializable;
import java.util.List;

public interface IWeapon extends Cloneable, Serializable {
    double getDamage();
    void setDamage(double damage);
    double getShotSpeed();
    void setShotSpeed(double shotSpeed);
    double getFireRate();
    void setFireRate(double fireRate);
    double getShotDuration();
    void setShotDuration(double duration);
    Vector2 getProjectileSize();
    void setProjectileSize(Vector2 shotSize);
    ImageSprite getHudIcon();
    List<IProjectile> Shoot(Vector2 direction, Vector2 position);
    List<IProjectile> ContinueShooting(double delta, Vector2 direction, Vector2 position);
    List<IProjectile> AddTimeWithoutShoot(double delta);
    IWeapon clone();
    Weapon getBaseWeapon();
}
