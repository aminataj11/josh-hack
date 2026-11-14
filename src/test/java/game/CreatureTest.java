package game;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreatureTest {
    private World world;
    private Creature creature;

    @BeforeEach
    void setUp() {
        Tile[][][] tiles = new Tile[3][3][1];
        for (int x = 0; x < 3; x++) {
            
            for (int y = 0; y < 3; y++) {
                tiles[x][y][0] = Tile.FLOOR;
            }
        }
        
        world = new World(tiles);
        creature = new Creature(world, '@', Color.GRAY, "josh", 100, 10, 5);
        creature.x = 1;
        
        creature.y = 1;

        creature.z = 0;
    }

    @Test
    void testModifyHp_healingCapsAtMax() {
        // try to heal past maxHp and make sure it caps correctly
        creature.modifyHp(50, "super potion");
        assertEquals(100, creature.hp());
    }

    @Test
    
    void testModifyHp_triggersDeathPath() {
        // deal massive damage so hp drops below 1 and triggers death/removal
        creature.modifyHp(-150, "fell off a cliff");
        assertTrue(CombatRules.isDead(creature.hp()));
    }
}