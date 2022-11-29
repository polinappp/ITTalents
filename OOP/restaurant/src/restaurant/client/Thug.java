package restaurant.client;

import restaurant.Restaurant;
import restaurant.menuItem.IThugItem;

public class Thug extends Client{
    public Thug(String name, Restaurant restaurant) {
        super(name, 50, restaurant);
    }

    @Override
    protected IThugItem pickItem() {
        return restaurant.getMenu().getRandomThugItem();
    }
}
