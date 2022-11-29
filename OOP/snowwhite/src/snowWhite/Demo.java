package snowWhite;

public class Demo {
    public static void main(String[] args) {

        Factory factory = new Factory("Talent Gifts Laplandia OOD");

        for (int i = 0; i < 100; i++) {
            Child child = new Child(Utility.getRandomName() + i, Utility.getRandomCity());
            Child.factory = factory;
            child.sendLetter();
        }

        factory.getSnowWhite().startWork();
    }
}
