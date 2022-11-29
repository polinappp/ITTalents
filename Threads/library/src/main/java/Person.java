import chetiva.Chetivo;

public class Person extends Thread{
    private String name;
    private Chetivo chetivo;
    public static Library library;

    public Person(String name) {
        this.name=name;
    }
    @Override
    public void run() {
        if(Thread.currentThread().isDaemon()) {
            while(true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Sleep Daemon");
                }
                library.revision();
            }

        } else {
            while(true) {
                chooseCategory();
            }
        }

    }

    public String getPersonName() {
        return name;
    }

    private void chooseCategory() {

        int chance = Utilities.getR().nextInt(100);
        if(chance < 33) {
            library.rentBook();
        } else if (chance < 66) {
            library.rentMagazine();
        } else {
            library.rentTextbook();
        }
    }
}
