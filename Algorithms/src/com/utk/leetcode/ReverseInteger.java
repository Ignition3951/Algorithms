package com.utk.leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    private static final Logger LOGGER = Logger.getLogger(ReverseInteger.class.getName());

    public static void main(String[] args) {
        int x = -123;
        LOGGER.log(Level.INFO, "Reverse of number is : {0}", reverse(x));
    }

    public static int reverse(int x) {
        StringBuilder reverseNumber = new StringBuilder();
        int originalNumber = x;
        if (x < 0) {
            x = -x;
        }
        while (x > 0) {
            int lastdigit = x % 10;
            reverseNumber.append(lastdigit);
            x = x / 10;
        }
        if (originalNumber < 0) {
            reverseNumber.insert(0,'-');
        }
        int result;
        try {
            result = Integer.parseInt(reverseNumber.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return result;
    }
}
