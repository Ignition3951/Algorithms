package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursionSum {

    private static final Logger LOGGER = Logger.getLogger(RecursionSum.class.getName());

    public static void main(String[] args) {
        int n=5;
        LOGGER.log(Level.INFO, "Sum of first {0} natural numbers: {1}", new Object[]{n, sum(n)});
    }

    public static int sum(int n){
        int result=n;
        if(n>=1){
            result += sum(n-1);
        }
        return result;
    }
}
