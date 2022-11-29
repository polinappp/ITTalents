public class Cashier extends Thread{
    public static GasStation gasStation;

    public Cashier(){

    }

    @Override
    public void run() {
        while(true) {
            gasStation.lookForKasa();
        }
    }
}
