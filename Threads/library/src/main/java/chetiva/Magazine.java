package chetiva;

import java.time.LocalDate;

public class Magazine extends Chetivo {

    private int numberOfMagazine;
    private LocalDate dateOfPublish;

    public Magazine(String name, int numberOfMagazine, String dateOfPublish, String publisher, String category) {
        super(name, publisher, category, 0);
        this.numberOfMagazine=numberOfMagazine;
        this.dateOfPublish = LocalDate.parse(dateOfPublish);
    }
}
