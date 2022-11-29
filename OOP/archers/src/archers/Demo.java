package archers;

import archers.archer.AdvancedArcher;
import archers.archer.Archer;
import archers.archer.RookieArcher;
import archers.archer.VeteranArcher;
import archers.bow.*;

public class Demo {
    public static void main(String[] args) {

        Club club = new Club("IT Archers");

        for (int i = 0; i < 40; i++) {
            Archer archer;

            int chance = Utility.getRandom().nextInt(100);
            if(chance < 33) {
                archer = new RookieArcher("Archer" + i, Utility.getRandom().nextBoolean(), Utility.getRandomInt(12, 52), new WoodenBow(Utility.getRandomInt(20, 30)));
            } else if(chance < 66) {
                SeniorBow bow = Utility.getRandom().nextBoolean() ? new AluminiumBow(Utility.getRandomInt(25, 40)) :
                        new CarbonBow(Utility.getRandomInt(28, 48));

                archer = new AdvancedArcher("Archer" + i, Utility.getRandom().nextBoolean(), Utility.getRandomInt(12, 52), bow, Utility.getRandomInt(3, 10));
            } else {
                archer = new VeteranArcher("Archer" + i, Utility.getRandom().nextBoolean(), Utility.getRandomInt(12, 52), new CarbonBow(Utility.getRandomInt(28, 48)), Utility.getRandomInt(10, 30));
            }

            club.addArcher(archer);
        }
        club.startTournament();

    }
}
