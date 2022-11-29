import java.time.LocalDateTime;
import java.util.*;

public class Column {
    private int columnID;
    private boolean isFree;
    private Queue<Car> cars;

    public Column(int columnID) {
        this.columnID = columnID;
        this.isFree = true;
        this.cars = new LinkedList<>();
    }

    public void addCar(Car car) {
        synchronized (cars) {
            cars.offer(car);
            cars.notifyAll();
        }
    }

    public void fillTank() {
        synchronized (cars) {
            while(cars.isEmpty()) {
                try {
                    cars.wait();
                } catch (InterruptedException e) {
                    System.out.println("Fill tank wait problem");
                }
            }

            Car car = cars.poll();
            car.setFuelQuantity(new Random().nextInt(31) + 10);
            try {
                Thread.sleep(car.getDuration());
            } catch (InterruptedException e) {
                System.out.println("Fill tank sleep gone wrong");
            }

            car.setLoadingTime(LocalDateTime.now());
            car.setTankIsFilled(true);
            cars.notifyAll();
        }
    }

    public Queue<Car> getCars() {
        return cars;
    }

    public int getColumnID() {
        return columnID;
    }
}
