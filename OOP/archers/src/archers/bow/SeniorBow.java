package archers.bow;

public class SeniorBow extends Bow {
    private static int scope = 1;

    public SeniorBow(int strength, boolean hasScope, boolean hasStabilizer) {
        super(strength, hasScope, hasStabilizer);
    }

    public static int getScope() {
        return scope;
    }
}
