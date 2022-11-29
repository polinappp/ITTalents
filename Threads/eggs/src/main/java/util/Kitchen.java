package util;

import eggs.Egg;
import people.Father;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Kitchen {
    private BlockingQueue<Egg> pot;
    private ArrayList<Jar> bukrani;
    private HashMap<String, ArrayList<Egg>> hladilnik;
    public static Father father;

    public Kitchen() {
        this.pot = new ArrayBlockingQueue<>(50);
        this.bukrani = new ArrayList<>();
        this.hladilnik = new HashMap<>();

        for (int i = 0; i < 50; i++) {
            this.pot.offer(new Egg());
        }

        for (int i = 0; i < 5; i++) {
            this.bukrani.add(new Jar(i+1));
        }
    }

    public Egg getEgg() {
        try {
            return pot.take();
        } catch (InterruptedException e) {
            System.out.println("Get egg fail");
            return null;
        }
    }

    public void addToJar(Egg egg) {
        try {
            synchronized (bukrani) {
                while (jarsAreFull()) {
                    bukrani.wait();
                }
            }
            Jar jar = getFreeJar();
            synchronized (jar) {
                jar.addEgg(egg);
                egg.setJar(jar);
                Thread.sleep(egg.getType().getDuration());
                egg.setColor(jar.getColor());
                egg.setDate(LocalDateTime.now());

                synchronized (bukrani) {
                    System.out.println("Egg added to jar " + jar.getId());
                    bukrani.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Add to jar grrrr");
        }
    }

    private synchronized Jar getFreeJar() {
        return bukrani.stream().filter(jar -> !jar.isBusy()).findAny().get();
    }

    private boolean jarsAreFull() {
        return this.bukrani.stream().allMatch(jar -> jar.isBusy());
    }

    public Egg getEggFromJar() {
        synchronized (bukrani) {
            try {
                while (jarsEmpty()) {
                    bukrani.wait();
                }
                Egg egg = getFreeNotEmptyJar().takeEgg();
                bukrani.notifyAll();
                return egg;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean jarsEmpty() {
        return bukrani.stream().allMatch(jar -> jar.getEggs().isEmpty());
    }

    private synchronized Jar getFreeNotEmptyJar() {
        return bukrani.stream().filter(jar -> !jar.getEggs().isEmpty()).findAny().get();
    }
    public void putInFridge(Egg egg) {
        if(!hladilnik.containsKey(egg.getType().getName())) {
            hladilnik.put(egg.getType().getName(), new ArrayList<Egg>());
        }

        hladilnik.get(egg.getType().getName()).add(egg);

        father.writeDown();
        father.putInDb(egg);
    }

    public HashMap<String, ArrayList<Egg>> getHladilnik() {
        return hladilnik;
    }
}
