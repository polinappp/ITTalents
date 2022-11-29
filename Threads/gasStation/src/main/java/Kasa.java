import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

public class Kasa {

    private int kasaID;
    private Queue<Car> cars;
    public static GasStation gasStation;
    public Kasa(int kasaID) {
        this.kasaID=kasaID;
        this.cars = new LinkedList<>();
    }

    public void addToKasa(Car car) {
        synchronized (cars) {
            cars.add(car);
            cars.notifyAll();
        }
    }

    public Queue<Car> getCars() {
        return cars;
    }

    public int getKasaID() {
        return kasaID;
    }

    public void work() {
        synchronized (cars) {
            while(cars.isEmpty()) {
                try {
                    cars.wait();
                } catch (InterruptedException e) {
                    System.out.println("Kasa work wait problem");
                }
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Car car = cars.poll();
            String data = car.getColumn_id() + ", " + car.getFuel() + ", " + car.getFuelQuantity() + ", " + car.getLoadingTime().format(formatter);
            gasStation.addToLoadings(kasaID, data);
            //gasStation.addToDB(car);
            double price = getPrice(car);
            gasStation.pay(price);
            car.setHasPaid(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Kasa sleep problem");
            }
            cars.notifyAll();
        }
    }

    private double getPrice(Car car) {
        double price;
        if(car.getFuel().equals("Benzin")) {
            price = car.getFuelQuantity()*2;
        } else if(car.getFuel().equals("Gas")) {
            price = car.getFuelQuantity()*1.60;
        } else {
            price = car.getFuelQuantity()*2.40;
        }

        return price;
    }
}
