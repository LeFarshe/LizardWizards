package com.lizardwizards.lizardwizards.core.gameplay.enemies.mediator;


import com.lizardwizards.lizardwizards.core.gameplay.Entity;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import com.lizardwizards.lizardwizards.core.gameplay.enemies.Enemy;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for EnemyMediator
 *
 * @see EnemyMediator
 * @author povilas
 */
public class EnemyMediatorTest
{
    /**
     * Parasoft Jtest UTA: Test for handleCollision(Enemy, Entity, CollisionLayer)
     *
     * @author povilas
     * @see EnemyMediator#handleCollision(Enemy, Entity, CollisionLayer)
     */
    @Test
    public void testHandleCollision() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyMediator underTest = new EnemyMediator();

            // When
            Enemy enemy = mock(Enemy.class);
            Entity collider = mock(Entity.class);
            CollisionLayer layer = CollisionLayer.Enemy; // UTA: default value
            underTest.handleCollision(enemy, collider, layer);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for updateEnemyState(Enemy)
     *
     * @author povilas
     * @see EnemyMediator#updateEnemyState(Enemy)
     */
    @Test
    public void testUpdateEnemyState() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            EnemyMediator underTest = new EnemyMediator();

            // When
            Enemy enemy = mock(Enemy.class);
            underTest.updateEnemyState(enemy);

        });
    }
}