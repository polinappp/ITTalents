package people;

import eggs.Egg;
import util.Kitchen;

public class Kid extends Thread{
    private int id;
    public static Kitchen kitchen;

    public Kid(String name, int id) {
        super(name);
        this.id=id;
    }

    @Override
    public void run() {
        while(true) {
            Egg egg = kitchen.getEgg();
            System.out.println(Thread.currentThread().getName() + " took an egg from pot " + egg.getType().getName());
            egg.setKid(this);

            kitchen.addToJar(egg);
        }
    }

    public int getKidId() {
        return id;
    }
}
