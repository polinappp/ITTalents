package restaurant.menuItem.food;

import restaurant.menuItem.MenuItem;

public abstract class Food extends MenuItem {
    private double grams;

    public Food(String name, double price, double grams) {
        super(name, price);
        if(validGrams(grams)) {
            this.grams = grams;
        } else {
            this.grams = (minGrams()+maxGrams())/2;
        }
    }

    public boolean validGrams(double grams) {
        if(grams <= maxGrams() && grams >= minGrams()) {
            return true;
        }
        return false;
    }

    @Override
    public String getKind() {
        return "Food";
    }

    protected abstract double minGrams();

    protected abstract double maxGrams();
}
