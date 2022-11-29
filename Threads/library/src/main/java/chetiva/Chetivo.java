package chetiva;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Chetivo implements Serializable {
    private String name;
    private String publisher;
    private String type;
    private double tax;
    ArrayList<RentDetails> rentHistoryOfBook;


    public Chetivo(String name, String publisher, String type, double tax) {
        this.name = name;
        this.publisher = publisher;
        this.type=type;
        this.tax = tax;
        rentHistoryOfBook=new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getTax() {
        return tax;
    }

    public ArrayList<RentDetails> getRentHistory() {
        return rentHistoryOfBook;
    }

    public void addRentDetails(RentDetails rentDetails) {
        rentHistoryOfBook.add(rentDetails);
    }
}
