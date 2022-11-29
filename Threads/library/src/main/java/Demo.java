public class Demo {
    public static void main(String[] args) {

        Library library = new Library();
        library.print();

        Person.library=library;
        for (int i = 0; i < 30; i++) {
            Person person = new Person("Person " + i);
            person.start();
        }

        Person libraryWoman = new Person("Library Woman");
        libraryWoman.setDaemon(true);
        libraryWoman.start();
    }
}
