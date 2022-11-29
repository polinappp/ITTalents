package cakes.cake;

public class SpecialCake extends Cake{
    private String event;


    public SpecialCake(String name, double price, String type, int pieces, String event) {
        super(name, price, type, pieces);
        this.event = event;
    }
}
