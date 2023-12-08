package UnitTests;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class moving {
    @Test
    void playerMovingTest(){


        var player = new Player(new Vector2(0, 0), 100);
        player.StartMoving(new Vector2(1, 1));
        player.MoveByDelta(0.01);
        assertEquals(player.GetPosition().DistanceTo(new Vector2(1, 1)), 0);
    }
}
