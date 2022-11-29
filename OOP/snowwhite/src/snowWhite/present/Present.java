package snowWhite.present;

import snowWhite.Child;

import java.util.Comparator;

public abstract class Present {
    private String packageColor;
    private Child owner;
    private double price;

    public Present(Child owner) {
        this.owner = owner;
    }

    public void setPackageColor(String color) {
        this.packageColor = color;
    };

    public String getPackageColor() {
        return packageColor;
    }

    public Child getOwner() {
        return owner;
    }

    public void setPrice(double price) {
        this.price = price;
    };
    public abstract int minPrice();
    public abstract int maxPrice();

    public double getPrice() {
        return price;
    }

    public static Comparator<Present> byChimney = new Comparator<Present>() {
        @Override
        public int compare(Present o1, Present o2) {
            return Boolean.compare(o2.getOwner().hasChimney(), o1.getOwner().hasChimney());
        }
    };

    @Override
    public String toString() {
        return "Present{" +
                "packageColor='" + packageColor + '\'' +
                ", owner=" + owner +
                ", price=" + price +
                '}';
    }
}
