import eggs.Egg;
import people.Father;
import people.Kid;
import people.Mama;
import util.Kitchen;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Kitchen kitchen = new Kitchen();
        Mama.kitchen = kitchen;
        Father.kitchen = kitchen;
        Kid.kitchen = kitchen;
        Mama mama = new Mama("Mama");
        Father tati = new Father("Tati");
        Kitchen.father= tati;

        for (int i = 0; i < 3; i++) {
            Kid kid = new Kid("Kid " + (i + 1), (i + 1));
            kid.start();
        }

        mama.start();
    }
}
