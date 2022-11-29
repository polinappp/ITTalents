import java.util.Random;

public class Utilities {
    private static final String[] BOOK_NAMES = { "Biscuit", "Eclair", "Fruit", "Chocolate"};
    private static final String[] MAGAZINE_NAMES = { "GQ", "VOGUE", "W", "Cosmo"};
    private static final String[] TEXTBOOK_NAMES = { "Textbook1", "Textbook2", "Textbook3", "Textbook4"};
    private static final String[] GENRES = { "Romance", "Horror", "Historical", "Thriller", "Fantasy"};
    private static final String[] CATEGORIES = { "Fashion", "Cooking", "Historical"};
    private static final String[] TOPICS = { "History", "Science", "Physics", "Maths"};
    private static final String[] AUTHORS = { "Polina", "Stephanie", "Martin", "Viktor"};
    private static final String[] PUBLISHERS = { "Publish1", "Publish2", "Publish3"};
    private static final Random r = new Random();

    public static String getRandomBookName() {
        return BOOK_NAMES[r.nextInt(BOOK_NAMES.length)];
    }

    public static String getRandomMagazineName() {
        return MAGAZINE_NAMES[r.nextInt(MAGAZINE_NAMES.length)];
    }
    public static String getRandomTextbookName() {
        return TEXTBOOK_NAMES[r.nextInt(TEXTBOOK_NAMES.length)];
    }
    public static String getRandomGenre() {
        return GENRES[r.nextInt(GENRES.length)];
    }
    public static String getRandomCategory() {
        return CATEGORIES[r.nextInt(CATEGORIES.length)];
    }
    public static String getRandomTopic() {
        return TOPICS[r.nextInt(TOPICS.length)];
    }
    public static String getRandomAuthor() {
        return AUTHORS[r.nextInt(AUTHORS.length)];
    }
    public static String getRandomPublisher() {
        return PUBLISHERS[r.nextInt(PUBLISHERS.length)];
    }

    public static Random getR() {
        return r;
    }
}
