package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CombatRulesTest {

    @Test
    void testCalculateNewHp_normalHealing() {
    
        int hp = CombatRules.calculateNewHp(50, 100, 20);
        assertEquals(70, hp);
    }

    @Test
    void testCalculateNewHp_hitsMaxHp() {
        // When healing hits maxHp exactly on the boundary
        int hp = CombatRules.calculateNewHp(80, 100, 30);
        assertEquals(100, hp);
    }

    @Test
    void testCalculateNewHp_exceedsMaxHp() {
        // Upper bound caps when healing goes over maxHp
        int hp = CombatRules.calculateNewHp(90, 100, 20);
        assertEquals(100, hp);
    }

    @Test
    void testCalculateNewHp_takesDamage() {
        // Negative damage where creature survives
        int hp = CombatRules.calculateNewHp(50, 100, -20);
        assertEquals(30, hp);
    }

    @Test
    void testIsDead_survives() {
        //  HP is above 0, creature should not be dead
        boolean dead = CombatRules.isDead(10);
        assertFalse(dead);
    }

    @Test
    void testIsDead_deadAtZero() {
        // Boundary transition where HP drops to 0
        boolean dead = CombatRules.isDead(0);
        assertTrue(dead);
    }

    @Test
    void testIsDead_deadNegative() {
        // Lethal damage where HP goes negative
        boolean dead = CombatRules.isDead(-5);
        assertTrue(dead);
    }

    @Test
    void testIsDead_exactOneHpBoundary() {
        // check exact boundary right above 0
        assertFalse(CombatRules.isDead(1));
    }

    @Test
    void testCalculateNewHp_zeroChange() {
        // make sure passing 0 doesn't change current HP
        assertEquals(50, CombatRules.calculateNewHp(50, 100, 0));
    }
}