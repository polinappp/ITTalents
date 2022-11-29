package snowWhite;

import snowWhite.present.Present;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dwarf {
    public static Factory factory;
    private String name;
    private int height;
    private Set<Present> presentsMade;

    public Dwarf(String name) {
        this.name = name;
        this.height = Utility.getRandomHeight();
        this.presentsMade = new HashSet<>();
    }

    public void makePresent(Present present) {
        present.setPackageColor(Utility.getRandomColor());
        double price = Utility.getRandomInt(present.minPrice(), present.maxPrice());

        if(!present.getOwner().isNaughty()) {
            price += (0.2*price);
        }

        present.setPrice(price);
        presentsMade.add(present);
        factory.increaseExpenses(price);
        factory.addPresent(present);
    }

    public void makePresent(ArrayList<Present> presents) {
        for (int i = 0; i < presents.size(); i++) {
            Present present = presents.get(i);
            makePresent(present);
        }
    }

    public Set<Present> getPresentsMade() {
        return presentsMade;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
