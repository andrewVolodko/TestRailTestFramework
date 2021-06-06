package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {

    public static String getRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
