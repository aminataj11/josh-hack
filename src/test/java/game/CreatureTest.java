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
    void testModifyHp_survivesAtOneHp() {
        // make sure taking 99 damage from 100 leaves 1 HP and doesn't trigger death
        creature.modifyHp(-99, "barely survived");
        assertEquals(1, creature.hp());
        assertFalse(CombatRules.isDead(creature.hp()));
    }

    
}