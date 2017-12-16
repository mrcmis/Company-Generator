package structures;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomString {

    public static String getRandomString() {

        Random generator = new Random();
        String randomString = RandomStringUtils.randomAlphabetic(generator.nextInt(15));

        return randomString;
    }

}
