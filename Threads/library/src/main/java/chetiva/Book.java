package chetiva;

import java.time.LocalDate;

public class Book extends Chetivo {
    private String author;
    private LocalDate dateOfPublish;


    public Book(String name, String author, String dateOfPublish, String publisher, String genre) {
        super(name, publisher, genre, 2);
        this.author=author;
        this.dateOfPublish = LocalDate.parse(dateOfPublish);
    }


}
