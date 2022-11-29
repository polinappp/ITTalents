package restaurant.client;

import restaurant.Restaurant;
import restaurant.menuItem.IVeganItem;

public class Vegan extends Client{

    public Vegan(String name, Restaurant restaurant) {
        super(name, 30, restaurant);
    }

    @Override
    protected IVeganItem pickItem() {
        return restaurant.getMenu().getRandomVeganItem();
    }
}
