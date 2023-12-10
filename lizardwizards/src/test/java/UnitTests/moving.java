package UnitTests;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class moving {
    @Test
    void playerMovingTest(){
        double[][] tests = {
            {0,0,100,1,0,0.02,2,0},
            {540,200,-500,0.707,0.707,0.05,522.322,182.322},
            {0.001,-0.001,147,0,-1,0.01,0.001,-1.471},
            {231,10,200,0,0,0.1,231,10},
            {0,150000,100000000000.0,0,1,0.03,0,3000150000.0}
        };

        for (var i : tests){
            var player = new Player(new Vector2(i[0], i[1]), i[2]);
            player.StartMoving(new Vector2(i[3], i[4]));
            player.MoveByDelta(i[5]);
            assertTrue(player.GetPosition().DistanceTo(new Vector2(i[6], i[7])) < 0.005);
        }
    }
}
