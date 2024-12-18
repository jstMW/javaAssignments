package Ass3.q2;
import java.util.Random;
public enum FlyerStatus {
    GOLD, SILVER, BRONZE, NONE;

    public static FlyerStatus randomValue() {
        Random rand = new Random();
        int ordinal = rand.nextInt()%4;
        for (FlyerStatus f: FlyerStatus.values()) {
            if (f.ordinal() == ordinal) { return f; }
        }
    }


}
