package people;

import eggs.Egg;
import util.DBManager;
import util.Kitchen;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Father{

    public static Kitchen kitchen;

    private String name;
    public Father(String name) {
        this.name=name;
    }

    public void writeDown() {

        try(PrintStream ps = new PrintStream("fridge.txt")){
            HashMap<String, ArrayList<Egg>> hladilnik = kitchen.getHladilnik();
            for (Map.Entry<String, ArrayList<Egg>> type : hladilnik.entrySet()
                 ) {
                ps.println("Type: " + type.getKey());
                for (Egg egg : type.getValue()
                     ) {
                        ps.println("\t" + egg.getColor() + " - " + egg.getType().getName() + " - " + egg.getKid().getName() + " - " + egg.isPartyColored() + " - " + egg.getDate());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("mamka mu");
        }
    }

    public void putInDb(Egg egg) {
        DBManager.addEggToDB(egg);
    }
}
