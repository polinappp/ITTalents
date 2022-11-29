package cakes.client;

import cakes.Bakery;
import cakes.Supplier;
import cakes.Utility;
import cakes.cake.Cake;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Client {
    private String name;
    private String phoneNum;
    public static Bakery BAKERY;
    public double spentMoney;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(phoneNum, client.phoneNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNum);
    }

    public abstract int getRandomCakeNum();
    public void makeOrder() {
        ArrayList<Cake> order = new ArrayList<Cake>();

        Supplier supplier = BAKERY.getSupplier();

        int cakeNum = Utility.getRandomInt(3,5);
        for (int i = 0; i < cakeNum; i++) {
            Cake cake = pickCake();
            if(cake != null) {
                order.add(cake);
                spentMoney += cake.getPrice();
                BAKERY.removeCake(cake);
            }
        }

        getDiscount();
        supplier.deliverOrder(this, order);

        double tip = getTip();
        supplier.getPaid(spentMoney, tip);

    }

    protected abstract double getTip();

    public double getSpentMoney() {
        return spentMoney;
    }

    public abstract void getDiscount();
    protected Cake pickCake() {
        return BAKERY.pickFromCatalogue();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", spentMoney=" + spentMoney +
                '}';
    }
}
