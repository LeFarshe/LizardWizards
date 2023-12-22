package com.lizardwizards.lizardwizards.core.gameplay;


import com.lizardwizards.lizardwizards.client.SpriteColor;
import com.lizardwizards.lizardwizards.client.sprites.EntitySprite;
import com.lizardwizards.lizardwizards.core.Vector2;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for EntityWrapper
 *
 * @see EntityWrapper
 * @author povilas
 */
public class EntityWrapperTest
{
    /**
     * Parasoft Jtest UTA: Test for Move(Vector2)
     *
     * @author povilas
     * @see EntityWrapper#Move(Vector2)
     */
    @Test
    public void testMove() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            Vector2 amount = mock(Vector2.class);
            underTest.Move(amount);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for MoveByDelta(double, HashMap)
     *
     * @author povilas
     * @see EntityWrapper#MoveByDelta(double, HashMap)
     */
    @Test
    public void testMoveByDelta() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            double delta = 0.0d; // UTA: default value
            HashMap<UUID, EntityWrapper> entities = new HashMap<UUID, EntityWrapper>(); // UTA: default value
            UUID key = UUID.randomUUID();
            EntityWrapper value = mock(EntityWrapper.class);
            entities.put(key, value);
            underTest.MoveByDelta(delta, entities);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetColor(SpriteColor)
     *
     * @author povilas
     * @see EntityWrapper#SetColor(SpriteColor)
     */
    @Test
    public void testSetColor() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            SpriteColor color = mock(SpriteColor.class);
            underTest.SetColor(color);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for SetPosition(Vector2)
     *
     * @author povilas
     * @see EntityWrapper#SetPosition(Vector2)
     */
    @Test
    public void testSetPosition() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            Vector2 position = mock(Vector2.class);
            underTest.SetPosition(position);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for clone()
     *
     * @author povilas
     * @see EntityWrapper#clone()
     */
    @Test
    public void testClone() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            EntityWrapper result = underTest.clone();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for update(EntityWrapper)
     *
     * @author povilas
     * @see EntityWrapper#update(EntityWrapper)
     */
    @Test
    public void testUpdate() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Entity entity = mock(Entity.class);
            EntitySprite sprite = mock(EntitySprite.class);
            EntityWrapper underTest = new EntityWrapper(entity, sprite);

            // When
            EntityWrapper entityWrapper = mock(EntityWrapper.class);
            underTest.update(entityWrapper);

        });
    }
}