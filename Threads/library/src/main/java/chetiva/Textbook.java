package chetiva;

public class Textbook extends Chetivo{
    private String author;

    public Textbook(String name, String author, String publisher, String topic) {
        super(name, publisher, topic, 3);
        this.author = author;
    }
}
