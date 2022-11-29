package chetiva;

import java.time.LocalDate;

public class RentDetails {
    private String reader;
    private String bookName;
    private double payment;

    public RentDetails(String reader, String bookName) {
        this.reader=reader;
        this.bookName=bookName;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPayment() {
        return payment;
    }

    public String getBookName() {
        return bookName;
    }

    public String getReader() {
        return reader;
    }

}
