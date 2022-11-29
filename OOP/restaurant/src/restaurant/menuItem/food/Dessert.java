package restaurant.menuItem.food;


public class Dessert extends Food {

    public Dessert(String name, double grams) {
        super(name,4, grams);
    }

    @Override
    public String getType() {
        return "Dessert";
    }

    @Override
    protected double minGrams() {
        return 200;
    }

    @Override
    protected double maxGrams() {
        return 300;
    }
}
