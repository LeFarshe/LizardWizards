package UnitTests;

import com.lizardwizards.lizardwizards.core.gameplay.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class weaponSwitching {
    @Test
    void weaponSwitchingTests(){
        int[][] tests = {
                {2, 1, 1, 0},
                {3,0,-1,2},
                {1,0,1,0},
                {5,2,4,1},
                {2,0,-2,0}};

        for (int[] test: tests){
            Player player = createPlayer(test[0],test[1]);
            player.ChangeWeapon(test[2]);
            assertEquals(player.currentWeapon, test[3]);
        }
    }

    Player createPlayer(int weaponAmount, int currentWeapon){
        Player ans = new Player(null, 0);
        for(int i = 0; i < weaponAmount; i++){
            ans.weapons.add(null);
        }
        ans.currentWeapon = currentWeapon;
        return ans;
    }
}
