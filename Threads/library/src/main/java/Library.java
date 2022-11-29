import chetiva.*;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Library {
    private HashMap<String, HashMap<String, TreeSet<Chetivo>>> catalogue;
    private TreeSet<RentDetails> rentHistory;
    private double budget;
    
    public Library() {
        catalogue = new HashMap<>();
        makeCatalogue();
        rentHistory = new TreeSet<>((o1, o2) -> Double.compare(o1.getPayment(), o2.getPayment()));
    }

    private void makeCatalogue() {
        catalogue.put("Book", new HashMap<>());
        catalogue.put("Magazine", new HashMap<>());
        catalogue.put("Textbook", new HashMap<>());

        for (int i = 0; i < 9; i++) {
            String date = "2022-0"+(i+1)+"-"+(i+10);
            Chetivo book = new Book(Utilities.getRandomBookName(), Utilities.getRandomAuthor(), date, Utilities.getRandomPublisher(), Utilities.getRandomGenre());
            Chetivo magazine = new Magazine(Utilities.getRandomMagazineName(), Utilities.getR().nextInt(20), date, Utilities.getRandomPublisher(), Utilities.getRandomCategory());
            Chetivo textbook = new Textbook(Utilities.getRandomTextbookName(), Utilities.getRandomAuthor(), Utilities.getRandomPublisher(), Utilities.getRandomTopic());

            addBook(book);
            addMagazine(magazine);
            addTextbook(textbook);
        }
    }

    private void addTextbook(Chetivo textbook) {
        String topic = textbook.getType();

        if(!catalogue.containsKey("Textbook")) {
            catalogue.put("Textbook", new HashMap<>());
        }
        if(!catalogue.get("Textbook").containsKey(topic)) {
            catalogue.get("Textbook").put(topic, new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName())));
        }

        catalogue.get("Textbook").get(topic).add(textbook);
    }

    private void addMagazine(Chetivo magazine) {
        String category = magazine.getType();

        if(!catalogue.containsKey("Magazine")) {
            catalogue.put("Magazine", new HashMap<>());
        }
        if(!catalogue.get("Magazine").containsKey(category)) {
            catalogue.get("Magazine").put(category, new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName())));
        }

        catalogue.get("Magazine").get(category).add(magazine);
    }

    private void addBook(Chetivo book) {
        String genre = book.getType();

        if(!catalogue.containsKey("Book")) {
            catalogue.put("Book", new HashMap<>());
        }
        if(!catalogue.get("Book").containsKey(genre)) {
            catalogue.get("Book").put(genre, new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName())));
        }
        
        catalogue.get("Book").get(genre).add(book);
    }

    public void rentBook() {
        HashMap<String, TreeSet<Chetivo>> books = catalogue.get("Book");
        String genre = Utilities.getRandomGenre();
        while(!books.containsKey(genre)) {
            genre=Utilities.getRandomGenre();
        }

        synchronized (books) {
            try {
                while(books.get(genre).isEmpty()) {
                    books.wait();
                }

                Chetivo book = getChetivo("Book", genre);
                catalogue.get(book.getClass().getSimpleName()).get(book.getType()).remove(book);
                System.out.println(Thread.currentThread().getName() + " Book is rented " + book.getName() + " " + book.getType());

                int rentTime = Utilities.getR().nextInt(151) + 200;
                Thread.sleep(rentTime);
                RentDetails rentBook = new RentDetails(Thread.currentThread().getName(), book.getName());
                double payment = book.getTax();
                int rentedDays = 3;

                if(rentTime > 300) {
                    payment = payment + ((rentTime-300)*1.0)/100*payment;
                    rentedDays = Utilities.getR().nextInt(4) + 4;
                    addToRentHistory(rentBook);
                }

                rentBook.setPayment(payment);
                returnBook(book, rentedDays);
                System.out.println(Thread.currentThread().getName() + " Book is returned after " + rentTime + " secs " + book.getName());

                pay(payment);
                books.notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Books fucked up");
            }
        }
    }

    private void addToRentHistory(RentDetails rentBook) {
        rentHistory.add(rentBook);
    }

    private void pay(double payment) {
        budget+=payment;
    }

    private void returnBook(Chetivo book, int rentedDays) {
        catalogue.get(book.getClass().getSimpleName()).get(book.getType()).add(book);
    }

    private Chetivo getChetivo(String category, String type) {
        Chetivo chetivo = catalogue.get(category).get(type).first();
        return chetivo;
    }

    public void print() {
        for (Map.Entry<String, HashMap<String, TreeSet<Chetivo>>> type : catalogue.entrySet()
             ) {
            System.out.println(type.getKey());
            for (Map.Entry<String, TreeSet<Chetivo>> category : type.getValue().entrySet()
                 ) {
                System.out.println("\t" + category.getKey());
                for (Chetivo chetivo : category.getValue()
                     ) {
                    System.out.println("\t\t" + chetivo.getName());
                }
            }
        }

    }

    public void rentMagazine() {
        HashMap<String, TreeSet<Chetivo>> magazines = catalogue.get("Magazine");
        String category = Utilities.getRandomCategory();
        while(!magazines.containsKey(category)) {
            category=Utilities.getRandomCategory();
        }

        synchronized (magazines) {
            try {
                while(magazines.get(category).isEmpty()) {
                    magazines.wait();
                }

                Chetivo magazine = getChetivo("Magazine", category);
                catalogue.get(magazine.getClass().getSimpleName()).get(magazine.getType()).remove(magazine);
                System.out.println(Thread.currentThread().getName() + " You can't rent a magazine. Read it here. " + magazine.getName());
                Thread.sleep(100);

                returnBook(magazine, 0);
                System.out.println(Thread.currentThread().getName() + " Magazine is returned " + magazine.getName());
                magazines.notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Books fucked up");
            }
        }
    }


    public void rentTextbook() {
        HashMap<String, TreeSet<Chetivo>> textbooks = catalogue.get("Textbook");
        String topic = Utilities.getRandomTopic();
        while(!textbooks.containsKey(topic)) {
            topic=Utilities.getRandomTopic();
        }

        synchronized (textbooks) {
            try {
                while(textbooks.get(topic).isEmpty()) {
                    textbooks.wait();
                }

                Chetivo textbook = getChetivo("Textbook", topic);
                catalogue.get(textbook.getClass().getSimpleName()).get(textbook.getType()).remove(textbook);

                System.out.println(Thread.currentThread().getName() + " Textbook is rented " + textbook.getName());
                int rentTime = Utilities.getR().nextInt(51) + 200;
                Thread.sleep(rentTime);

                RentDetails rentTextbook = new RentDetails(Thread.currentThread().getName(), textbook.getName());
                double payment = textbook.getTax();
                int rentedDays = 3;

                if(rentTime > 200) {
                    payment = payment + ((rentTime-200)*1.0)/100*payment;
                    rentedDays = Utilities.getR().nextInt(3) + 6;
                    addToRentHistory(rentTextbook);
                }

                rentTextbook.setPayment(payment);
                returnBook(textbook, rentedDays);
                System.out.println(Thread.currentThread().getName() + " Textbook is returned after " + rentTime + " secs " + textbook.getName());

                pay(payment);
                textbooks.notifyAll();
            } catch (InterruptedException e) {
                System.out.println("Books fucked up");
            }
        }
    }

    public synchronized void revision() {
        System.out.println();
        System.out.println(Thread.currentThread().getName());
        getAvailableChetiva();
        takenBooks();
    }

    private void takenBooks() {

        try(FileWriter fos = new FileWriter("takenBooks.txt")) {
            for (RentDetails rentDetails : rentHistory
                 ) {
                String output = rentDetails.getBookName() + " - " + rentDetails.getReader() + " - " + rentDetails.getPayment()+ "\n";
                fos.write(output);
                fos.flush();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void getAvailableChetiva() {
        int availableChetiva = 0;
        for (Map.Entry<String, HashMap<String, TreeSet<Chetivo>>> type : catalogue.entrySet()
        ) {
            for (Map.Entry<String, TreeSet<Chetivo>> category : type.getValue().entrySet()
            ) {
                for (Chetivo chetivo : category.getValue()
                ) {
                    availableChetiva++;
                }
            }
        }

        System.out.println("Available Chetiva: " + availableChetiva);
        System.out.println();
    }
}
