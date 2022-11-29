package snowWhite.present;

import snowWhite.Child;
import snowWhite.Utility;

public class Cloth extends Present{
    private String size;
    private String fabric;


    public Cloth(Child owner) {
        super(owner);
        this.size = Utility.getRandomSize();
        this.fabric = Utility.getRandomFabric();
    }

    @Override
    public int minPrice() {
        return 2;
    }

    @Override
    public int maxPrice() {
        return 12;
    }
}
