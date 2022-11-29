package cakes.cake;

public class StandardCake extends Cake{
    private boolean hasSyrup;


    public StandardCake(String name, double price, String type, int pieces, boolean hasSyrup) {
        super(name, price, type, pieces);
        this.hasSyrup = hasSyrup;
    }
}
