package restaurant.menuItem.food;

import restaurant.menuItem.IVeganItem;

public class Salad extends Food implements IVeganItem {

    public Salad(String name, double grams) {
        super(name,5, grams);
    }

    @Override
    public String getType() {
        return "Salad";
    }

    @Override
    protected double minGrams() {
        return 300;
    }

    @Override
    protected double maxGrams() {
        return 600;
    }
}
