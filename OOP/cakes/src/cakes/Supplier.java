package cakes;

import cakes.cake.Cake;
import cakes.client.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Supplier {
    private String name;
    private String phoneNum;
    private double tips;
    private HashMap<Client, List<Cake>> orders;
    public static Bakery bakery;

    public Supplier(String name) {
        this.name = name;
        this.orders = new HashMap<>();
    }

    public void deliverOrder(Client client, ArrayList<Cake> order) {
        orders.put(client, order);
    }

    public void getPaid(double spentMoney, double tip) {
        bakery.putMoneyInCashier(spentMoney);
        tips += tip;
    }

    public double getTips() {
        return tips;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", tips=" + tips +
                '}';
    }

    public HashMap<Client, List<Cake>> getOrders() {
        return orders;
    }
}
