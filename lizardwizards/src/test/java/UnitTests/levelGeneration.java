package UnitTests;

import com.lizardwizards.lizardwizards.core.Vector2;
import com.lizardwizards.lizardwizards.core.gameplay.levels.Level;
import com.lizardwizards.lizardwizards.core.gameplay.levels.LevelFacade;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class levelGeneration {
    @ParameterizedTest(name = "{index} => rooms={0}, deadEnds={1}, randomFail={2}")
    @CsvSource({
            "10, 3, 0.5",
            "25, 8, 0.2",
            "6, 3, 0.7",
            "10, 5, 0.5",
            "50, 15, 0.6"
    })
    void levelGenerationTests(int rooms, int deadEnds, double randomFail){
        LevelFacade facade = new LevelFacade();

        Level level = facade.getCustomLevel(rooms, deadEnds, randomFail);
        assertAll("Level generation",
                () -> assertEquals(rooms, countRooms(level)),
                () -> assertTrue(countDeadEnds(level) >= deadEnds,
                        "Dead end count must be equal or greater than the requested minimum"));
    }

    int countRooms(Level level){
        return allRooms(level).size();
    }

    int countDeadEnds(Level level){
        List<Vector2> rooms = allRooms(level);
        int deadEnds = 0;
        // Center room never counts as a dead end
        int center = (level.size - 1) / 2;
        Vector2[] checks = {
                new Vector2(-1,0),
                new Vector2(0,1),
                new Vector2(1,0),
                new Vector2(0,-1)
        };

        for (Vector2 room: rooms){
            if (room.x == center && room.y == center) { continue;}

            int adjacent = 0;

            for (Vector2 adjacentCoordinate: checks){
                Vector2 roomTemp = room.Copy().AddVector(adjacentCoordinate);
                if (level.canMove(roomTemp)) { adjacent++;}
            }


            if (adjacent <= 1) { deadEnds++;}
        }

        return deadEnds;
    }

    List<Vector2> allRooms(Level level){
        List<Vector2> rooms = new ArrayList<>();
        for (int x = 0; x < level.size; x++){
            for (int y = 0; y < level.size; y++){
                Vector2 pos = new Vector2(x,y);
                if (level.canMove(pos)){
                    rooms.add(pos);
                }
            }
        }
        return rooms;
    }
}
