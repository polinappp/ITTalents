package cakes;

import java.util.Random;

public class Utility {

    private static final String[] STANDARD_CAKES = { "Biscuit", "Eclair", "Fruit", "Chocolate"};
    private static final String[] WEDDING_CAKES = { "Big", "Small", "Medium"};
    private static final String[] SPECIAL_CAKES = { "Anniversary", "Corporate", "Advertisement"};
    private static final String[] KID_CAKES = { "Birthday", "Baby Shower", "Prodigal"};
    private static final Random r = new Random();

    public static String getRandomStandard() {
        return STANDARD_CAKES[r.nextInt(STANDARD_CAKES.length)];
    }
    public static String getRandomWedding() {
        return WEDDING_CAKES[r.nextInt(WEDDING_CAKES.length)];
    }public static String getRandomSpecial() {
        return SPECIAL_CAKES[r.nextInt(SPECIAL_CAKES.length)];
    }public static String getRandomKids() {
        return KID_CAKES[r.nextInt(KID_CAKES.length)];
    }
    public static Random getR() {
        return r;
    }
    public static int getRandomInt(int min, int max) {
        return r.nextInt(max-min) + min +1;
    }
}
