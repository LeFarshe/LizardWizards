package com.lizardwizards.lizardwizards.core.gameplay.projectiles;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LaggyProjectileCaretaker extends ProjectileDecorator{
    List<LaggyProjectileSnapshot> snapshots;
    static double newSnapshotMulti = 0.2;
    static double restoreMulti = 0.3;
    static double durationMulti = 3;
    double newSnapshotDelay, restoreDelay, trueDuration;
    double newSnapshotTime = 0;
    double restoreTime = 0;
    static Random rand = new Random();
    public LaggyProjectileCaretaker(IProjectile projectile) {
        super(projectile);
        this.newSnapshotDelay = projectile.getDuration() * rand.nextDouble() * newSnapshotMulti;
        this.restoreDelay = projectile.getDuration() * rand.nextDouble() * restoreMulti;
        this.trueDuration = projectile.getDuration() * rand.nextDouble() * durationMulti;
        snapshots = new ArrayList<>();
    }

    @Override
    public void MoveByDelta(double delta){
        wrappedProjectile.MoveByDelta(delta);
        trueDuration -=delta;
        if (trueDuration <= 0){
            wrappedProjectile.setErase(true);
        }
        newSnapshotTime += delta;
        if (newSnapshotTime >= newSnapshotDelay){
            newSnapshotTime -= newSnapshotDelay;
            addSnapshot();
        }
        restoreTime += delta;
        if (restoreTime >= restoreDelay){
            restoreTime -= restoreDelay;
            restoreRandom();
        }
    }

    public void restoreRandom(){
        if (!snapshots.isEmpty()){
            snapshots.get(rand.nextInt(0, snapshots.size())).restore();
        }
    }
    public void addSnapshot(){
        snapshots.add(createSnapshot());
    }

    @Override
    public double getDuration(){
        return trueDuration;
    }

    @Override
    public IProjectile clone() {
        return new LaggyProjectileCaretaker(wrappedProjectile.clone());
    }
}
