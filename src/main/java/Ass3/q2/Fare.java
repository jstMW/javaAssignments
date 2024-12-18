import java.util.Random;
public Enum Fare {
    FULL, DISC, BUDDY

    public Fare randomValue() {
        Random rand = new Random();
        int ordinal = rand.nextInt()%3;
        for (Fare f: Fare.values()) {
            if (f.ordinal() == ordinal) { return f; }

        }
    }
}
