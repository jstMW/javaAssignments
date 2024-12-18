package Ass3.q2;
import java.util.Random;
public class FlyerStatus {
    GOLD, SILVER, BRONZE, NONE

    public Fare randomValue() {
        Random rand = new Random();
        int ordinal = rand.nextInt()%4;
        for (Fare f: Fare.values()) {
            if (f.ordinal() == ordinal) { return f; }
        }
    }


}
