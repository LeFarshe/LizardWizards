package UnitTests;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.collision.Collider;
import com.lizardwizards.lizardwizards.core.gameplay.collision.CollisionLayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class collision {
    @Test
    void collisionTest(){
        double[][] tests = {
                {0,0,5,2,3,0,4,5, 1},
                {0,0,10,10,100,100,10,10, 0},
                {5,5,4,4,2,5,2,2, 1},
                {0,0,50,50,10,11,4,10, 1},
                {5,2,4,8.999,5,10,2,7, 0}};

        for (double[] test: tests){
            Vector2 pos1 = new Vector2(test[0], test[1]);
            Vector2 pos2 = new Vector2(test[4], test[5]);
            Collider collider1 = Collider.NewRectangle(pos1,test[2], test[3], CollisionLayer.Obstacle);
            Collider collider2 = Collider.NewRectangle(pos2,test[6], test[7], CollisionLayer.Obstacle);
            boolean temp = 1 == test[8];
            assertEquals(temp, collider1.Collide(collider2));
        }
    }
}
