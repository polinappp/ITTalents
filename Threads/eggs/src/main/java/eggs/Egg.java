package eggs;

import people.Kid;
import util.Jar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Egg {
    private int id;
    private EggType type;
    private String color;
    private boolean isPartyColored;
    private LocalDateTime date;
    private Jar jar;
    private Kid kid;

    public Egg() {
        int chance = new Random().nextInt(100);
        EggType type;
        if(chance < 33) {
            type = new EggType(1);
        } else if (chance < 66) {
            type = new EggType(2);
        } else {
            type = new EggType(4);
        }

        this.type = type;

    }

    public EggType getType() {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Jar getJar() {
        return jar;
    }

    public String getColor() {
        return color;
    }

    public Kid getKid() {
        return kid;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isPartyColored() {
        return isPartyColored;
    }

    public void setPartyColored(boolean partyColored) {
        isPartyColored = partyColored;
    }

    public int getId() {
        return id;
    }

    public void setKid(Kid kid) {
        this.kid = kid;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setJar(Jar jar) {
        this.jar = jar;
    }
}
