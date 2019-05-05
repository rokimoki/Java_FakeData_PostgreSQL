package Controller;
public class RandomStringController {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String numbers = "1234567890";

    public static String getRandomString(int length) {
        return generateRandomString(length, alphabet);
    }

    public static String getRandomNumericString(int length) {
        return generateRandomString(length, numbers);
    }

    private static String generateRandomString(int length, String alphabet) {
        char [] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = alphabet.charAt((int) Math.floor(Math.random() * alphabet.length()));
        }
        return new StringBuilder().append(result).toString();
    }
}
