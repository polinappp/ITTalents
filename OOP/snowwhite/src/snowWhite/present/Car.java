package snowWhite.present;

import snowWhite.Child;
import snowWhite.Utility;

public class Car extends Present{
    private int batteries;

    public Car(Child owner) {
        super(owner);
        this.batteries = Utility.getRandomInt(2, 6);
    }

    @Override
    public int minPrice() {
        return 20;
    }

    @Override
    public int maxPrice() {
        return 40;
    }
}
