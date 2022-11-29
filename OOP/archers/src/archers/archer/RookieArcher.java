package archers.archer;

import archers.Utility;
import archers.bow.WoodenBow;

public class RookieArcher extends Archer{

    public RookieArcher(String name, boolean isMale, int age, WoodenBow bow) {
        super(name, isMale, age, bow, 1);
    }

    @Override
    public void shoot() {
        for (int i = 0; i < 30; i++) {
            boolean success = Utility.getChance(90);

            if(success) {
                int shot = Utility.getRandom().nextInt(10)+1;
                improvePoints(shot);
            } else {
                this.misses++;
            }
        }
    }
}
