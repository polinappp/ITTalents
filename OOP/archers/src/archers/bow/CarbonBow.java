package archers.bow;

public class CarbonBow extends SeniorBow {
    private static int stabilizer = 2;

    public CarbonBow(int strength) {
        super(strength, true, true);
    }

    public static int getStabilizer() {
        return stabilizer;
    }
}
