import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    // Method to simulate rolling a dice and returning the result
    public static int roll() {
        // Generate a random number between 1 and 6 (inclusive) to simulate a 6-sided
        // dice roll
        return random.nextInt(6) + 1;
    }
}
