package restaurant;

import restaurant.menuItem.IMenuItem;
import restaurant.menuItem.Menu;

import java.util.*;

public class Restaurant {
    private String name;
    private String address;
    private double budget;
    private Menu menu;
    private TreeSet<Waiter> waiters;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.budget = 1000;
        this.waiters = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            waiters.add(new Waiter("Waiter" + (i+1)));
        }

        this.menu = new Menu();
    }

    public Waiter getWaiter() {
        ArrayList<Waiter> list = new ArrayList<>();
        list.addAll(waiters);

        return list.get(Utility.getRandom().nextInt(list.size()));
    }

    public Menu getMenu() {
        return menu;
    }

    public void addToBudget(double price) {
        budget += price;
    }

    public void removeFromMenu(IMenuItem item) {
        menu.removeItem(item);
    }

    public void balance() {
        System.out.println("Balance - " + budget);
    }

    public void statistics() {
        balance();
        biggestTip();
        getWaiters();
        printMenu();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("MENU");
        for (Map.Entry<String, HashMap<String, ArrayList<IMenuItem>>> e : menu.getMenu().entrySet()
             ) {
            System.out.println(e.getKey());
            for (Map.Entry<String, ArrayList<IMenuItem>> ee : e.getValue().entrySet()
                 ) {
                System.out.println("\t" + ee.getKey() + " - " + ee.getValue().size());
            }
        }
    }


    private void getWaiters() {
        System.out.println();
        System.out.println("WAITERS");

        ArrayList<Waiter> waiters1 = new ArrayList<>();
        waiters1.addAll(waiters);
        Collections.sort(waiters1, (o1, o2) -> Double.compare(o2.getTips(), o1.getTips()));

        for (Waiter w : waiters1) {
            System.out.println(w.getName() + " - " + w.getTips());
        }
    }

    private void biggestTip() {
        System.out.println("Waiter with biggest tip: " + waiters.first().getName() + " - " + waiters.first().getTips());
    }
}
