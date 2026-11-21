package game;

/**
 * Helper class for combat HP math and death checks.
 */
public final class CombatRules {

    private CombatRules() {
        // utility class shouldn't be instantiated
    }

    public static int calculateNewHp(int currentHp, int maxHp, int amount) {
        int newHp = currentHp + amount;
        if (newHp > maxHp) {
            return maxHp;
        }
        return newHp;
    }

    public static boolean isDead(int hp) {
        return hp < 1;
    }
}