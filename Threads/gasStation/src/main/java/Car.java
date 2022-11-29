import java.time.LocalDateTime;
import java.util.Random;

public class Car extends Thread{
    private int column_id;
    private int fuelQuantity;
    private String fuel;
    private int duration;
    private boolean tankIsFilled;
    private boolean hasPaid;
    private static GasStation gasStation;

    private LocalDateTime loadingTime;

    public Car(GasStation gasStation) {
        this.gasStation = gasStation;
        this.tankIsFilled = false;
        this.hasPaid = false;
        this.duration = 5000;
    }

    public void setTankIsFilled(boolean tankIsFilled) {
        this.tankIsFilled = tankIsFilled;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public boolean isTankIsFilled() {
        return tankIsFilled;
    }

    @Override
    public void run() {
        while(true) {
            int chance = new Random().nextInt(100);
            if(chance < 33) {
                this.fuel = "Gas";
            } else if(chance < 66) {
                this.fuel = "Benzin";
            } else {
                this.fuel = "Diesel";
            }

            System.out.println(Thread.currentThread().getName() + " fill with " + this.fuel);
            this.column_id = pickAColumn();
            System.out.println(Thread.currentThread().getName() + " picked column " + this. column_id);
            gasStation.lineUp(this, this.column_id);
        }
    }

    private int pickAColumn() {
        int chance = new Random().nextInt(100);
        if(chance < 20) {
            return 0;
        } else if (chance < 40){
            return 1;
        } else if(chance < 60) {
            return 2;
        } else if(chance < 80) {
            return 3;
        } else {
            return 4;
        }
    }

    public int getDuration() {
        return duration;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void goToCashier() {
        int cashier = new Random().nextInt(2);
        System.out.println(Thread.currentThread().getName() + " choose cashier " + (cashier+1));
        gasStation.lineUpAtKasa(this, cashier);
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public String getFuel() {
        return fuel;
    }

    public int getFuelQuantity() {
        return fuelQuantity;
    }

    public void leave() {
        hasPaid = false;
        tankIsFilled = false;
    }

    public void setLoadingTime(LocalDateTime loadingTime) {
        this.loadingTime = loadingTime;
    }

    public LocalDateTime getLoadingTime() {
        return loadingTime;
    }
}
