package archers.bow;

public abstract class Bow {
    private String producer;
    private double weight;
    private int strength;
    private boolean hasScope;
    private boolean hasStabilizer;


    public Bow(int strength, boolean hasScope, boolean hasStabilizer) {
        //todo validation
        this.strength = strength;
        this.hasScope = hasScope;
        this.hasStabilizer = hasStabilizer;
    }

    public boolean hasScope() {
        return hasScope;
    }

    public boolean hasStabilizer() {
        return hasStabilizer;
    }
}
