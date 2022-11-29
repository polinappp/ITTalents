package snowWhite;

import snowWhite.present.Present;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Factory {
    private String name;
    private String address;
    private String postCode;
    private ArrayList<Dwarf> dwarves;
    private Map<String, Map<String, ArrayList<Present>>> storage;
    private double expenses;
    private ArrayList<Letter> postBox;
    private Map<String, ArrayList<Present>> sleight;
    private SnowWhite snowWhite;
    private int denials;


    public Factory(String name) {
        this.name = name;
        expenses = 0;
        denials = 0;

        dwarves = new ArrayList<>();

        storage = new HashMap<>();
        storage.put("Good", new HashMap<>());
        storage.put("Naughty", new HashMap<>());

        postBox = new ArrayList<>();
        sleight = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

        for(int i = 0; i < 15; i++) {
            Dwarf dwarf = new Dwarf(Utility.getRandomName() + i);
            Dwarf.factory = this;
            dwarves.add(dwarf);
        }
        snowWhite = new SnowWhite(this);
    }

    public void addLetter(Letter letter) {
        postBox.add(letter);
    }

    public void addPresent(Present present) {
        if(present.getOwner().isNaughty()) {
            if(!(storage.get("Naughty").containsKey(present.getClass().getName()))) {
                storage.get("Naughty").put(present.getClass().getName(), new ArrayList<>());
            }

            storage.get("Naughty").get(present.getClass().getName()).add(present);
        } else {
            if(!(storage.get("Good").containsKey(present.getClass().getName()))) {
                storage.get("Good").put(present.getClass().getName(), new ArrayList<>());
            }

            storage.get("Good").get(present.getClass().getName()).add(present);
        }
    }

    public void increaseExpenses(double price) {
        expenses += price;
    }
    public ArrayList<Dwarf> getDwarves() {
        return dwarves;
    }

    public Map<String, Map<String, ArrayList<Present>>> getStorage() {
        return storage;
    }

    public Map<String, ArrayList<Present>> getSleight() {
        return sleight;
    }

    public ArrayList<Letter> getPostBox() {
        return postBox;
    }

    public SnowWhite getSnowWhite() {
        return snowWhite;
    }

    public void printSleigh() {
        for (Map.Entry<String, ArrayList<Present>> chuval : sleight.entrySet()) {
            System.out.println(chuval.getKey());

            for (int i = 0; i < chuval.getValue().size(); i++) {
                System.out.println("  " + chuval.getValue().get(i));
            }
            System.out.println();
        }
    }
    public void addToSleigh(Present present) {
        if(!sleight.containsKey(present.getOwner().getCity())) {
            sleight.put(present.getOwner().getCity(), new ArrayList<>());
        }

        sleight.get(present.getOwner().getCity()).add(present);
    }

    public int getDenials() {
        return denials;
    }

    public double getExpenses() {
        return expenses;
    }

    public void increaseDenials() {
        denials++;
    }

}
