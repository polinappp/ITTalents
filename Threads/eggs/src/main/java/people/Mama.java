package people;

import eggs.Egg;
import util.Kitchen;

import java.util.Random;

public class Mama extends Thread{
    public static Kitchen kitchen;

    public Mama(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            Egg egg = kitchen.getEggFromJar();
            System.out.println("Mama took an egg from jar " + egg.getJar().getColor());
            egg.setPartyColored(colorEgg(egg));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            kitchen.putInFridge(egg);
        }
    }

    private boolean colorEgg(Egg egg) {
        int chance = new Random().nextInt(100);
        if(chance < 20) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Color egg gone wrong");
            }
            return true;
        }
        return false;
    }
}
