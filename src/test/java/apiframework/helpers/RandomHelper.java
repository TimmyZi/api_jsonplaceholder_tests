package apiframework.helpers;

import java.util.Random;

public class RandomHelper {

    private static final Random RANDOM = new Random();
    private static final int FIRST_ENGLISH_LETTER_UNICODE = 'A';
    private static final int LAST_ENGLISH_LETTER_UNICODE = 'z';

    public static int generateInt(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }

    public static String getRandomString(int length) {
        return generateRandomString(length);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char letter = (char) (generateInt(FIRST_ENGLISH_LETTER_UNICODE, LAST_ENGLISH_LETTER_UNICODE + 1));
            sb.append(letter);
        }
        return sb.toString();
    }
}