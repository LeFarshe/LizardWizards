package UnitTests;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.weapons.TestWeapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class shooting {
    @Test
    void shootingTest(){
        double[][] tests = {
                {0.49, 2, 0.02, 0.01},
                {1.2, 0.5, 0.04, 1.24},
                {0.099, 10, 0.03, 0.029},
                {9.8999, 0.1, 0.1, 9.9999},
                {0.89, 1, 0.02, 0.91}};

        for (double[] test: tests){
            Vector2 testingPos = new Vector2(0, 0);
            TestWeapon wpn1 = new TestWeapon(test[0], test[1]);
            String[] div = ((Double)test[3]).toString().split("\\.");
            int aDC = div[1].length();
            wpn1.ContinueShooting(test[2], testingPos, testingPos);
            assertEquals(test[3] * Math.pow(10, aDC), Math.round(wpn1.fireTimer * Math.pow(10, aDC)));
        }
    }
}
