package restaurant.menuItem.food;

import restaurant.menuItem.IThugItem;

public class MainMeal extends Food implements IThugItem {

    public MainMeal(String name, double grams) {
        super(name,9, grams);
    }

    @Override
    public String getType() {
        return "Main Meal";
    }

    @Override
    protected double minGrams() {
        return 400;
    }

    @Override
    protected double maxGrams() {
        return 800;
    }
}
