package cakes.cake;

public class KidCake extends Cake{
    private String kidName;


    public KidCake(String name, double price, String type, int pieces, String kidName) {
        super(name, price, type, pieces);
        this.kidName = kidName;
    }
}
