package archers.archer;

import archers.bow.Bow;
import archers.bow.CarbonBow;
import archers.bow.SeniorBow;

import java.util.ArrayList;

public abstract class Archer {
    private String name;
    private boolean isMale;
    private int age;
    protected Bow bow;
    private int experience;
    private int competitions = 0;
    protected ArrayList<Integer> points;
    protected int misses = 0;

    public Archer(String name, boolean isMale, int age, Bow bow, int experience) {
        //todo validation
        this.name = name;
        this.isMale = isMale;
        this.age = age;
        this.bow = bow;
        this.experience = experience;
        this.points = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Archer: " +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", age=" + age;
    }

    public abstract void shoot();

    public void improvePoints(int shot) {
        if(shot != 10) {
            if(this.bow.hasScope()) {
                shot += SeniorBow.getScope();
            }

            if(this.bow.hasStabilizer()) {
                if(shot + CarbonBow.getStabilizer() <= 10) {
                    shot += CarbonBow.getStabilizer();
                }
            }
        }

        points.add(shot);
    }

    public int getExperience() {
        return experience;
    }

    public boolean isMale() {
        return isMale;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        int point = 0;
        for (int i = 0; i < points.size(); i++) {
            point += points.get(i);
        }

        return point;
    }

    public int getMisses() {
        return misses;
    }
}
