package restaurant.menuItem.beverage;

import restaurant.menuItem.IVeganItem;

public class SoftDrink extends Beverage implements IVeganItem {

    public SoftDrink(String name) {
        super(name,2);
    }

    @Override
    public String getType() {
        return "Soft Drink";
    }
}
