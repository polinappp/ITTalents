package cakes;

import cakes.cake.Cake;

import java.util.ArrayList;
import java.util.Collections;

public class Bakery {

    private String name;
    private String address;
    private String contactNumber;
    Catalogue catalogue;
    private ArrayList<Supplier> suppliers;
    private double budget;

    public Bakery(String name) {
        this.name = name;
        this.suppliers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Supplier supplier = new Supplier("Supplier" + (i+1));
            suppliers.add(supplier);
        }
        Supplier.bakery = this;
    }


    public void makeCatalogue() {
        this.catalogue = new Catalogue();
    }

    public void printCat() {
        catalogue.print();
    }

    public Supplier getSupplier() {
        return suppliers.get(Utility.getR().nextInt(suppliers.size()));
    }

    public Cake pickFromCatalogue() {
        return catalogue.getRandomCake();
    }

    public void removeCake(Cake cake) {
        catalogue.removeCake(cake);
    }

    public void putMoneyInCashier(double spentMoney) {
        budget+=spentMoney;
    }

    public double getBudget() {
        return budget;
    }

    public void getSuppliers() {
        Collections.sort(suppliers, (o1, o2) -> Double.compare(o2.getTips(),o1.getTips()));

        System.out.println("SUPPLIERS");
        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println(suppliers.get(i));
        }
    }

    public void supplierWithMostOrders() {
        Collections.sort(suppliers, (o1, o2) -> o2.getOrders().size()-o1.getOrders().size());
        System.out.println("\nSupplier with most orders: " + suppliers.get(0));
    }
}
