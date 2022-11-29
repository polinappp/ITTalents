package eggs;

public class EggType {
    private int id;
    private String name;
    private int duration;

    public EggType(int id) {
        this.id=id;
        switch(id) {
            case 1:
                this.name = "Kokoshka";
                this.duration = 10000;
                break;
            case 3:
                this.name = "Goose";
                this.duration = 5000;
                break;
            case 4:
                this.name = "Pate";
                this.duration = 3000;
                break;
            default:
                this.name = "Kokoshka";
                this.duration = 10000;
                this.id = 1;
        }
    }

    public int getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
