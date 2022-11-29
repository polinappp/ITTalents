package snowWhite.present;

import snowWhite.Child;
import snowWhite.Utility;

public class Doll extends Present{
    private int length;
    private int width;
    private String hairColor;

    public Doll(Child owner) {
        super(owner);
        length = Utility.getRandomInt(20, 60);
        width = Utility.getRandomInt(20,40);
        hairColor = Utility.getRandomColor();
    }


    @Override
    public int minPrice() {
        return 5;
    }

    @Override
    public int maxPrice() {
        return 10;
    }
}
