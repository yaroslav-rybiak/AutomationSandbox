package Data;

import java.util.Random;

public class Helper {

    protected static String HomeURL = "https://homemoney.ua/";
    protected static String email = "br59241@gmail.com";
    protected static String password = "oDo94oZmbB";

    public static String getHomeURL() {
        return HomeURL;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getRandomCash() {
        Random rand = new Random();
        int min = 100;
        int max = 999;
        int randomAmount = rand.nextInt((max - min) + 1) + min;
        return String.valueOf(randomAmount);
    }
}
