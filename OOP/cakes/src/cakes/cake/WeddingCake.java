package cakes.cake;

public class WeddingCake extends Cake{
    private int floors;


    public WeddingCake(String name, double price, String type, int pieces, int floors) {
        super(name, price, type, pieces);
        this.floors = floors;
    }
}
