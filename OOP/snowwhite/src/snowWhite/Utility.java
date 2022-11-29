package snowWhite;


import java.io.StringReader;
import java.util.Random;

public class Utility {

    private static final Random r = new Random();
    private static final String[] NAMES = {"Polina", "Stephanie", "Martin", "Viktor", "Jey"};
    private static final String[] CITIES= {"Sofia", "Varna", "New York", "Tokyo", "Toronto", "Amsterdam"};
    private static final String[] BOOKS= {"Sofia The Great", "Beauty and the Beast", "Cars", "Dinosaurs", "Bookland"};
    private static final String[] FABRICS= {"fabric1", "fabric2", "fabric3", "fabric4"};
    private static final String[] COLORS= {"brown", "pink", "black", "blue", "yellow", "purple"};

    private static final String[] SIZES= {"S", "M", "L", "XL"};
    public static String getRandomName() {
        return NAMES[r.nextInt(NAMES.length)];
    }

    public static String getRandomCity() {
        return CITIES[r.nextInt(CITIES.length)];
    }

    public static int getRandomHeight() {
        return r.nextInt(60) + 60;
    }

    public static String getRandomBook() {
        return BOOKS[r.nextInt(BOOKS.length)];
    }

    public static int getRandomInt(int min, int max) {
        return r.nextInt(max-min) + min;
    }

    public static String getRandomFabric() {
        return FABRICS[r.nextInt(FABRICS.length)];
    }
    public static String getRandomSize() {
        return SIZES[r.nextInt(SIZES.length)];
    }
    public static String getRandomColor() {
        return COLORS[r.nextInt(COLORS.length)];
    }
    public static Random getRandom() {
        return r;
    }

    public static boolean getChance(int chance) {
        return r.nextInt(100) < chance;
    }
}
