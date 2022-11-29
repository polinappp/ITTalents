package snowWhite;

import snowWhite.present.*;

public class Child {
    public static Factory factory;
    private String name;
    private String city;
    private boolean hasChimney;
    private boolean isNaughty;
    private Letter letter;

    public Child(String name, String city) {
        this.name = name;
        this.city = city;
        isNaughty = Utility.getChance(40);
        hasChimney = Utility.getRandom().nextBoolean();
    }
    public void sendLetter() {
        Letter letter = new Letter(this);
        Present present;

        int presentsNum = Utility.getRandomInt(1,10);
        for (int i = 0; i < presentsNum; i++) {
            present = createPresent();
            letter.addPresent(present);
        }
        this.letter = letter;

        factory.addLetter(this.letter);
    }


    private Present createPresent() {
        int chance = Utility.getRandom().nextInt(100);
        if(chance < 20) {
            return new Doll(this);
        }
        if(chance < 40) {
            return new Car(this);
        }
        if(chance < 60) {
            return new Cloth(this);
        }
        if(chance < 80) {
            return new Book(this);
        }
        return new Train(this);
    }

    public boolean isNaughty() {
        return isNaughty;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }


    public boolean hasChimney() {
        return hasChimney;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
