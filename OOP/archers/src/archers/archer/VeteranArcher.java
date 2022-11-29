package archers.archer;

import archers.Utility;
import archers.bow.CarbonBow;

public class VeteranArcher extends Archer{

    public VeteranArcher(String name, boolean isMale, int age, CarbonBow bow, int experience) {
        super(name, isMale, age, bow, experience);
    }

    @Override
    public void shoot() {
        for (int i = 0; i < 60; i++) {
            int shot = Utility.getRandom().nextInt(5)+6;
            improvePoints(shot);
        }
    }
}
