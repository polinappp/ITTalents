package snowWhite.present;


import snowWhite.Child;
import snowWhite.Utility;

public class Train extends Present{
    private boolean hasSmoke;

    public Train(Child owner) {
        super(owner);
        this.hasSmoke = Utility.getRandom().nextBoolean();
    }

    @Override
    public int minPrice() {
        return 15;
    }

    @Override
    public int maxPrice() {
        return 30;
    }
}
