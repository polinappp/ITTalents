package elections;

import java.util.Random;

public class Utility {
    private static final Random r = new Random();
    private static final String[] NAMES = { "Maya", "Slavi", "Kiril", "Kristina", "Lara", "Valentin"};
    private static final String[] CITIES = { "Sofia", "Varna", "Plovdiv", "Dobrich", "Haskovo", "Burgas"};

    public static boolean getChance(int chance) {
        return r.nextInt(100) < chance;
    }

    public static String getRandomName() {
        return NAMES[r.nextInt(NAMES.length)];
    }
    public static String getRandomCity() {
        return CITIES[r.nextInt(CITIES.length)];
    }
    public static int getRandomInt(int min, int max) {
        return r.nextInt(max-min) + min;
    }

    public static Random getRandom() {
        return r;
    }
}
