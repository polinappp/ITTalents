package cakes.client;

import cakes.Supplier;
import cakes.Utility;
import cakes.cake.Cake;

import java.util.ArrayList;

public class CorporateClient extends Client{
    private int discount;

    public CorporateClient(String name, int discount) {
        super(name);
        this.discount = discount;
    }


    @Override
    public void makeOrder() {
        ArrayList<Cake> order = new ArrayList<Cake>();

        Supplier supplier = BAKERY.getSupplier();

        int cakeNum = Utility.getRandomInt(3,5);
        for (int i = 0; i < cakeNum; i++) {
            Cake cake = super.pickCake();
            if(cake != null) {
                order.add(cake);
                spentMoney += cake.getPrice();
                BAKERY.removeCake(cake);
            }
        }

        spentMoney -= spentMoney*discount/100;
        supplier.deliverOrder(this, order);

        double tip = spentMoney + spentMoney*5/100;
        supplier.getPaid(spentMoney, tip);

    }

    @Override
    protected double getTip() {
        return spentMoney*5/100;
    }


    @Override
    public void getDiscount() {
        spentMoney -= spentMoney*discount/100;
    }

    @Override
    public int getRandomCakeNum() {
        return Utility.getRandomInt(3,5);
    }
}
