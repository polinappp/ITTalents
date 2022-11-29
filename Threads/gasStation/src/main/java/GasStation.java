import java.util.ArrayList;
import java.util.HashMap;

public class GasStation {
    private ArrayList<Column> columns;
    private ArrayList<Kasa> kasi;
    private HashMap<Integer, ArrayList<String>> loadings;
    double budget;

    public GasStation() {
        columns = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Column column = new Column(i);
            columns.add(column);
        }

        kasi = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Kasa kasa = new Kasa(i);
            kasi.add(kasa);
        }

        loadings = new HashMap<>();
    }

    public void lineUp(Car car, int column_id) {
        synchronized (columns) {
            columns.get(column_id).addCar(car);
            columns.notifyAll();
        }

        synchronized (columns.get(column_id)) {
            while(!car.isTankIsFilled()) {
                try {
                    columns.get(column_id).wait();
                } catch (InterruptedException e) {
                    System.out.println("Line up at column problem");
                }
            }
            
            car.goToCashier();
            columns.get(column_id).notifyAll();
        }
    }

    public void lineUpAtKasa(Car car, int cashier) {
        synchronized (kasi) {
            kasi.get(cashier).addToKasa(car);
            kasi.notifyAll();
        }

        synchronized (kasi.get(cashier)) {
            while(!car.isHasPaid()) {
                try {
                    kasi.get(cashier).wait();
                } catch (InterruptedException e) {
                    System.out.println("Line up at kasa problem");
                }
            }
            
            car.leave();
            System.out.println(Thread.currentThread().getName() + " left");
            kasi.get(cashier).notifyAll();
        }
    }
    
    public void lookForKasa() {
        Kasa kasa;
        synchronized (kasi) {
            while(kasiAreEmplty()) {
                try {
                    kasi.wait();
                } catch (InterruptedException e) {
                    System.out.println("LOOK for kasa problem");
                }
            }
            
            kasa = chooseKasa();
            kasi.notifyAll();
        }

        synchronized (kasi.get(kasa.getKasaID())) {
            kasa.work();
            kasi.get(kasa.getKasaID()).notifyAll();
        }
    }

    private Kasa chooseKasa() {
        return kasi.stream().filter(kasa -> !kasa.getCars().isEmpty()).findFirst().get();
    }

    private boolean kasiAreEmplty() {
        boolean kasiAreEmpty = true;
        for (Kasa kasa : kasi
             ) {
            if(!kasa.getCars().isEmpty()) {
                kasiAreEmpty = false;
            }
        }
        
        return kasiAreEmpty;
    }

    public void lookForColumn() {
        Column column;
        synchronized (columns) {
            while(columnsAreEmpty()) {
                try {
                    columns.wait();
                } catch (InterruptedException e) {
                    System.out.println("LOOK for column gone wrong");
                }
                break;
            }

            column = chooseColumn();
            columns.notifyAll();
        }

        synchronized (columns.get(column.getColumnID())) {
            column.fillTank();
            columns.get(column.getColumnID()).notifyAll();
        }

    }

    private boolean columnsAreEmpty() {
        boolean colsAreEmpty = true;
        for (Column column : columns
             ) {
            if(!column.getCars().isEmpty()) {
                colsAreEmpty = false;
                break;
            }
        }

        return colsAreEmpty;
    }

    private Column chooseColumn() {
        return columns.stream().filter(column -> !column.getCars().isEmpty()).findAny().get();
    }

    public void addToLoadings(int cashier, String loading) {
        if(!loadings.containsKey(cashier)) {
            loadings.put(cashier, new ArrayList<>());
        }

        loadings.get(cashier).add(loading);
    }

    public void pay(double price) {
        budget += price;
    }
}
