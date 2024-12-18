package Ass3.q2;
import java.util.Random;
public enum Fare {
    FULL, DISC, BUDDY;

    public Fare randomValue() {
        Random rand = new Random();
        int ordinal = rand.nextInt()%3;
        for (Fare f: Fare.values()) {
            if (f.ordinal() == ordinal) { return f; }

        }
    }
}
