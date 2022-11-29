package restaurant.menuItem.beverage;

import restaurant.menuItem.MenuItem;

public abstract class Beverage extends MenuItem {


    public Beverage(String name, double price) {
        super(name, price);
    }

    @Override
    public String getKind() {
        return "Beverage";
    }
}
