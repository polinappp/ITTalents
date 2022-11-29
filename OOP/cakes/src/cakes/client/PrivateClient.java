package cakes.client;

import cakes.Utility;


public class PrivateClient extends Client {
    private double vouchers;

    public PrivateClient(String name, int vouchers) {
        super(name);
        this.vouchers = vouchers;
    }

    @Override
    public int getRandomCakeNum() {
        return Utility.getR().nextInt(3)+1;
    }

    @Override
    protected double getTip() {
        return spentMoney*2/100;
    }

    @Override
    public void getDiscount() {
        if(vouchers > spentMoney) {
            spentMoney += (vouchers/2);
        }
    }

}