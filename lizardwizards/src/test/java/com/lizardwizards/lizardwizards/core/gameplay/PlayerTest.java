package com.lizardwizards.lizardwizards.core.gameplay;


import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.projectiles.IProjectile;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.Gun;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.IWeapon;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.TestWeapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PlayerTest
{
    private Player underTest;
    @BeforeEach
    void init(){
        Vector2 position = mock(Vector2.class);
        double speed = 0.0d;
        underTest = new Player(position, speed);
    }

    @Test
    public void testChangeWeapon() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = 0;


            int change = 1;
            underTest.ChangeWeapon(change);

        });
    }

    @Test
    public void testChangeWeapon2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = 0;


            int change = -1;
            underTest.ChangeWeapon(change);

        });
    }

    @Test
    public void testChangeWeapon3() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = 0;


            int change = 0;
            underTest.ChangeWeapon(change);

        });
    }


    @Test
    public void testCollide() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = true;

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy;
            underTest.Collide(collider, layer);

        });
    }


    @Test
    public void testCollide2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = false;

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Player;
            underTest.Collide(collider, layer);

        });
    }


    @Test
    public void testCollide3() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = false;
            underTest.health = 1;

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy;
            underTest.Collide(collider, layer);

        });
    }


    @Test
    public void testCollide4() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = false;
            underTest.health = 1;

            // When
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.EnemyProjectile;
            underTest.Collide(collider, layer);

        });
    }


    @Test
    public void testIsDestroyed() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            boolean result = underTest.IsDestroyed();

        });
    }


    @Test
    public void testMoveByDelta() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = false;
            underTest.isMoving = false;

            double delta = 0.0d;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testMoveByDelta2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = true;
            underTest.isMoving = false;
            underTest.currentImmuneTimer = 1;

            double delta = 0;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testMoveByDelta3() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.isImmune = true;
            underTest.isMoving = false;
            underTest.currentImmuneTimer = 1;

            double delta = 1;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testMoveByDelta4() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 moveDirectionValue = mock(Vector2.class);
            Vector2 CopyResult = mock(Vector2.class);
            Vector2 MultiplyResult = mock(Vector2.class);
            when(CopyResult.Multiply(anyDouble())).thenReturn(MultiplyResult);
            when(moveDirectionValue.Copy()).thenReturn(CopyResult);
            underTest.moveDirection = moveDirectionValue;
            underTest.isImmune = false;
            underTest.isMoving = true;

            double delta = 0.0d;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testMoveByDelta5() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 moveDirectionValue = mock(Vector2.class);
            Vector2 CopyResult = mock(Vector2.class);
            Vector2 MultiplyResult = mock(Vector2.class);
            when(CopyResult.Multiply(anyDouble())).thenReturn(MultiplyResult);
            when(moveDirectionValue.Copy()).thenReturn(CopyResult);
            underTest.moveDirection = moveDirectionValue;
            underTest.isImmune = true;
            underTest.isMoving = true;
            underTest.currentImmuneTimer = 1;

            double delta = 0;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testMoveByDelta6() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 moveDirectionValue = mock(Vector2.class);
            Vector2 CopyResult = mock(Vector2.class);
            Vector2 MultiplyResult = mock(Vector2.class);
            when(CopyResult.Multiply(anyDouble())).thenReturn(MultiplyResult);
            when(moveDirectionValue.Copy()).thenReturn(CopyResult);
            underTest.moveDirection = moveDirectionValue;
            underTest.isImmune = true;
            underTest.isMoving = true;
            underTest.currentImmuneTimer = 1;

            double delta = 1;
            underTest.MoveByDelta(delta);

        });
    }


    @Test
    public void testShoot() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            IWeapon item = mock(IWeapon.class);
            weaponsValue.add(item);
            underTest.weapons = weaponsValue;
            underTest.isShooting = false;
            underTest.currentWeapon = 0;

            double delta = 0.0d;
            List<IProjectile> result = underTest.Shoot(delta);

        });
    }


    @Test
    public void testShoot2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            IWeapon item = mock(IWeapon.class);
            weaponsValue.add(item);
            underTest.weapons = weaponsValue;
            Vector2 shootDirectionValue = mock(Vector2.class);
            underTest.shootDirection = shootDirectionValue;
            underTest.isShooting = true;
            underTest.currentWeapon = 0;

            double delta = 0.0d;
            List<IProjectile> result = underTest.Shoot(delta);

        });
    }


    @Test
    public void testStartMoving() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {

            Vector2 direction = mock(Vector2.class);
            underTest.StartMoving(direction);

        });
    }


    @Test
    public void testStopMoving() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.StopMoving();

        });
    }


    @Test
    public void testStartShooting() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 direction = mock(Vector2.class);
            underTest.StartShooting(direction);

        });
    }

    @Test
    public void testStopShooting() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            underTest.StopShooting();

        });
    }


    @Test
    public void testClone() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            Vector2 moveDirectionValue = mock(Vector2.class);
            underTest.moveDirection = moveDirectionValue;
            Vector2 shootDirectionValue = mock(Vector2.class);
            underTest.shootDirection = shootDirectionValue;

            Player result = underTest.clone();

        });
    }


    @Test
    public void testClone2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            Vector2 moveDirectionValue = mock(Vector2.class);
            underTest.moveDirection = moveDirectionValue;

            Player result = underTest.clone();

        });
    }


    @Test
    public void testClone3() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            Vector2 shootDirectionValue = mock(Vector2.class);
            underTest.shootDirection = shootDirectionValue;

            Player result = underTest.clone();

        });
    }


    @Test
    public void testClone4() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;

            Player result = underTest.clone();

        });
    }


    @Test
    public void testClone5() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            underTest.weapons = weaponsValue;
            Vector2 moveDirectionValue = mock(Vector2.class);
            underTest.moveDirection = moveDirectionValue;
            Vector2 shootDirectionValue = mock(Vector2.class);
            underTest.shootDirection = shootDirectionValue;

            Player result = underTest.clone();

        });
    }

    @Test
    public void testGetCurrentWeapon() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            IWeapon item = mock(IWeapon.class);
            weaponsValue.add(item);
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = -1;

            IWeapon result = underTest.getCurrentWeapon();

        });
    }


    @Test
    public void testGetCurrentWeapon2() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            weaponsValue.add(mock(IWeapon.class));
            weaponsValue.add(mock(IWeapon.class));
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = 0;

            IWeapon result = underTest.getCurrentWeapon();

        });
    }

    @Test
    public void testGetCurrentWeapon3() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            List<IWeapon> weaponsValue = new ArrayList<IWeapon>();
            IWeapon item = mock(IWeapon.class);
            weaponsValue.add(item);
            underTest.weapons = weaponsValue;
            underTest.currentWeapon = 0;

            IWeapon result = underTest.getCurrentWeapon();

        });
    }


    @Test
    public void testGetPosition() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 positionValue = mock(Vector2.class);
            underTest.position = positionValue;

            Vector2 result = underTest.GetPosition();

        });
    }


    @Test
    public void testMove() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {
            Vector2 positionValue = mock(Vector2.class);
            underTest.position = positionValue;

            Vector2 amount = mock(Vector2.class);
            underTest.Move(amount);

        });
    }


    @Test
    public void testSetPosition() throws Throwable {
        assertTimeoutPreemptively(ofMillis(5000), () -> {

            Vector2 position2 = mock(Vector2.class);
            underTest.SetPosition(position2);

        });
    }
}