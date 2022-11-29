package restaurant;

import restaurant.client.Client;
import restaurant.menuItem.IMenuItem;

import java.util.HashMap;
import java.util.List;

public class Waiter implements Comparable<Waiter>{
    public static Restaurant restaurant;
    private String name;
    private double tips;
    private HashMap<Client, List<IMenuItem>> orders;

    public Waiter(String name) {
        this.name = name;
        this.orders = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public double getTips() {
        return tips;
    }

    @Override
    public int compareTo(Waiter o) {
        if(this.getTips() == o.getTips()) {
            return 1;
        }
        return Double.compare(o.getTips(), this.getTips());
    }

    public void acceptOrder(Client client, List<IMenuItem> order) {
        orders.put(client, order);
    }

    public double getCheck(Client client) {
        if(orders.containsKey(client)) {
            double total = 0;
            for ( IMenuItem item : orders.get(client)
                 ) {
                total += item.getPrice();
            }
            return total;
        }
        return 0;
    }

    public void getPaid(double check, double tip, Client client) {
        tips += tip;
        if(orders.containsKey(client)) {
            orders.remove(client);
        }

        addToBill(check);
    }

    private void addToBill(double check) {
        restaurant.addToBudget(check);
    }
}
