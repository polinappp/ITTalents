package snowWhite.present;


import jdk.jshell.execution.Util;
import snowWhite.Child;
import snowWhite.Utility;

public class Book extends Present {
    private String name;
    private int stories;


    public Book(Child owner) {
        super(owner);
        this.name = Utility.getRandomBook();
        this.stories = Utility.getRandomInt(1, 5);
    }

    @Override
    public int minPrice() {
        return 10;
    }

    @Override
    public int maxPrice() {
        return 20;
    }
}
