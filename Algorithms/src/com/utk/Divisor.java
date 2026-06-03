package com.utk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Divisor {

    private static final Logger LOGGER = Logger.getLogger(Divisor.class.getName());

    public static void main(String[] args) {
        int n=6;
        LOGGER.log(Level.INFO, "Divisors of {0} are: {1}", new Object[]{n, java.util.Arrays.toString(divisor(n))});
    }

    public static int[] divisor(int n){
        int[] divisors = new int[(n/2)+1];
        int location=0;
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0){
                divisors[location++] = i;
            }
        }
        return divisors;
    }
}
