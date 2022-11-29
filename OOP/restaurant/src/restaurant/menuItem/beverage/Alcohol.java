package restaurant.menuItem.beverage;

import restaurant.menuItem.IThugItem;

public class Alcohol extends Beverage implements IThugItem {

    public Alcohol(String name) {
        super(name, 4);
    }

    @Override
    public String getType() {
        return "Alcohol";
    }
}
