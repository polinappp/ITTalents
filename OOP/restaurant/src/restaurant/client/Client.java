package restaurant.client;

import restaurant.Restaurant;
import restaurant.Utility;
import restaurant.Waiter;
import restaurant.menuItem.IMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Client {
    public Restaurant restaurant;
    private String name;
    private double money;
    private Waiter waiter;
    private double check;

    public Client(String name, double money, Restaurant restaurant) {
        this.name = name;
        this.money = money;
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Double.compare(client.money, money) == 0 && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }

    public void makeOrder() {
        this.waiter = restaurant.getWaiter();

        List<IMenuItem> order = new ArrayList<>();
        double cost = 0;
        while(true) {
            IMenuItem item = pickItem();
            if(item != null) {
                if(cost + item.getPrice() <= money*0.9) {
                    cost += item.getPrice();
                    restaurant.removeFromMenu(item);
                    order.add(item);
                } else {
                    break;
                }
            }
        }

        waiter.acceptOrder(this, order);
    }

    public void askForCheck() {
        this.check = waiter.getCheck(this);
    }

    public void payCheck() {
        double tip = 0;
        if(Utility.getChance(80)) {
            int percent = Utility.getRandomInt(5,10);
            tip = check*percent/100;
        }
        money -= (check+tip);
        waiter.getPaid(check, tip, this);
    }
    protected abstract IMenuItem pickItem();
}
