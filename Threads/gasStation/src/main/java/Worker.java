public class Worker extends Thread {
    public static GasStation gasStation;

    public Worker(){

    }

    @Override
    public void run() {
        while(true) {
            gasStation.lookForColumn();
        }
    }
}
