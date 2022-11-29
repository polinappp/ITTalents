package restaurant.client;

import restaurant.Restaurant;
import restaurant.menuItem.IMenuItem;

public class Student extends Client{

    public Student(String name, Restaurant restaurant) {
        super(name, 10, restaurant);
    }

    @Override
    protected IMenuItem pickItem() {
        return restaurant.getMenu().getRandomItem();
    }
}
