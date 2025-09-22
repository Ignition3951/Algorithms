package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Print {

    private static final Logger LOGGER = Logger.getLogger(Print.class.getName());

    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    public static void print(int n) {
        if (n == 1) {
            LOGGER.log(Level.INFO, "Printing number: {0}", n);
            return;
        }
        print(n - 1);
        LOGGER.log(Level.INFO, "Printing number: {0}", n);
    }
}
