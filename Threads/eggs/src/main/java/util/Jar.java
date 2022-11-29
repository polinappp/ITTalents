package util;

import eggs.Egg;

import java.util.ArrayList;

public class Jar {
    private int id;
    private String color;
    private ArrayList<Egg> eggs;

    public Jar(int id) {
        this.id = id;
        switch (id) {
            case 1:
                this.color = "Red"; break;
            case 2:
                this.color = "Green"; break;
            case 3:
                this.color = "Yellow"; break;
            case 4:
                this.color = "Orange"; break;
            case 5:
                this.color = "Blue"; break;
            default:
                this.color = "Blue";
        }

        eggs = new ArrayList<>(2);
    }

    public ArrayList<Egg> getEggs() {
        return eggs;
    }

    public void addEgg(Egg egg) {
        this.eggs.add(egg);
    }

    public String getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public boolean isBusy() {
        if(eggs.size() == 2) {
            return true;
        }
        return false;
    }

    public Egg takeEgg() {
        return this.eggs.remove(0);
    }
}
