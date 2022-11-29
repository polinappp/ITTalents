package cakes;

import cakes.client.Client;
import cakes.client.CorporateClient;
import cakes.client.PrivateClient;

import java.util.ArrayList;
import java.util.Collections;

public class Demo {
    public static void main(String[] args) {

        Bakery bakery = new Bakery("Sweet Talents");

        bakery.makeCatalogue();

        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            clients.add(new CorporateClient("Corporate Client" + (i+1), Utility.getRandomInt(5, 15)));
            clients.add(new PrivateClient("Private Client" + (i+1), Utility.getRandomInt(10, 120)));
        }
        Client.BAKERY = bakery;

        System.out.println("BEFORE ORDERS\n");
        bakery.printCat();

        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            client.makeOrder();
        }

        System.out.println("AFTER ORDERS\n");
        bakery.printCat();
        System.out.println();
        System.out.println("Budget: " + bakery.getBudget());
        System.out.println();
        bakery.getSuppliers();
        bakery.supplierWithMostOrders();

        Collections.sort(clients, (o1, o2) -> Double.compare(o2.getSpentMoney(), o1.getSpentMoney()));
        System.out.println();
        System.out.println("Client with most expensive order: " + clients.get(0));
    }
}
