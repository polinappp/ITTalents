package restaurant;

import restaurant.client.Client;
import restaurant.client.Student;
import restaurant.client.Thug;
import restaurant.client.Vegan;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Pesho The Talent's", "Pesho Street");
        Waiter.restaurant = restaurant;
        List<Client> clients = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Client client;

            int chance = Utility.getRandom().nextInt(100);

            if(chance < 20) {
                client = new Vegan("Vegan" + (i+1), restaurant);
            } else if(chance < 50) {
                client = new Student("Student" + (i+1), restaurant);
            } else {
                client = new Thug("Thug" + (i+1),restaurant);
            }

            clients.add(client);
        }

        for(Client c : clients) {
            c.makeOrder();
            c.askForCheck();
            c.payCheck();
        }

        restaurant.statistics();
    }
}
