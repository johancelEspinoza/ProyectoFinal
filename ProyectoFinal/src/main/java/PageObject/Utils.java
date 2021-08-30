package PageObject;

import java.util.Random;

public class Utils {

    public static String generateRandomEmail() {
        Random rnd = new Random();
        return "user" + rnd.nextInt(1000) + "@test.com";
    }
}
