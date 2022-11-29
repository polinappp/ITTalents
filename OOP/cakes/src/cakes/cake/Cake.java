package cakes.cake;

public abstract class Cake {
    private String name;
    private String description;
    private double price;
    private int pieces;
    private String type;

    public Cake(String name, double price, String type, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", pieces=" + pieces +
                '}';
    }

    public double getPrice() {
        return price;
    }
}
