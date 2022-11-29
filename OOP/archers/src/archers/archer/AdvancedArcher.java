package archers.archer;

import archers.Utility;
import archers.bow.SeniorBow;

public class AdvancedArcher extends Archer{

    public AdvancedArcher(String name, boolean isMale, int age, SeniorBow bow, int experience) {
        super(name, isMale, age, bow, experience);
    }

    @Override
    public void shoot() {
        for (int i = 0; i < 60; i++) {
            boolean success = Utility.getChance(95);
            int shot = 0;
            if(success) {
                shot = Utility.getRandom().nextInt(5)+6;
                improvePoints(shot);
            } else {
                this.misses++;
            }
        }
    }


}
