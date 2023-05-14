package org.greendapps.microservices.demoapp.utils;

import java.util.Random;

public class RandomUtil {

    private RandomUtil() {
    }

    public static int inRange(int min, int max) {
        if (min >= max)
            return 0;

        return new Random().nextInt((max - min) + 1) + min;
    }

}
