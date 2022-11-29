package snowWhite;

import snowWhite.present.Present;

import java.util.ArrayList;

public class Letter {
    private Child writer;
    private ArrayList<Present> presents;

    public Letter(Child writer) {
        this.writer = writer;
        presents = new ArrayList<>();
    }

    public void addPresent(Present present) {
        presents.add(present);
    }

    public Child getWriter() {
        return writer;
    }

    public ArrayList<Present> getPresents() {
        return presents;
    }
}
