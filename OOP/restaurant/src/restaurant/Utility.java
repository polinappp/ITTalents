package restaurant;

import java.util.Random;

public class Utility {
    private static Random r = new Random();

    public static int getRandomInt(int min, int max) {
        return r.nextInt(max-min) + min + 1;
    }

    public static Random getRandom() {
        return r;
    }

    public static boolean getChance(int chance) {
        return r.nextInt(100) < chance;
    }
}
