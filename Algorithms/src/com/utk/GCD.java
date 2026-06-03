package com.utk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GCD {

    private static final Logger LOGGER = Logger.getLogger(GCD.class.getName());

    public static void main(String[] args) {
        int a = 9;
        int b = 8;
        LOGGER.log(Level.INFO, "GCD of {0} and {1} is: {2}", new Object[]{a, b, gcd(a, b)});
    }

    public static int gcd(int a, int b) {
        int greatest;
        greatest = (a >= b) ? a : b;
        for (int i = greatest / 2; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

}
