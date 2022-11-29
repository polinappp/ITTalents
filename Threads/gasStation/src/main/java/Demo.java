public class Demo {
    public static void main(String[] args) {
        GasStation station = new GasStation();
        Worker.gasStation = station;
        Cashier.gasStation = station;
        Kasa.gasStation = station;

        for (int i = 0; i < 10; i++) {
            Car car = new Car(station);
            car.start();
        }

        Worker worker = new Worker();
        Worker worker2 = new Worker();
        Cashier cashier = new Cashier();
        Cashier cashier1 = new Cashier();
        worker.start();
        worker2.start();
        cashier.start();
        cashier1.start();
    }
}
