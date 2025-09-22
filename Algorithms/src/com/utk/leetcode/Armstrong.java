package com.utk.leetcode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Armstrong {

    private static final Logger LOGGER = Logger.getLogger(Armstrong.class.getName());

    public static void main(String[] args) {
    int number=12;
        if(isArmstrong(number)){
            LOGGER.log(Level.INFO,"{0} is an Armstrong number.",number);
        } else {
            LOGGER.log(Level.INFO,"{0} is not an Armstrong number.",number);
        }
    }

    public static boolean isArmstrong(int number){
        int originalNumber = number;
        int sum=0;
        int digits = String.valueOf(number).length();

        while(number>0){
            int digit = number%10;
            sum += Math.pow(digit,digits);
            number=number/10;
        }
        return (sum==originalNumber);
    }
}
