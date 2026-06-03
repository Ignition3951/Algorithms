package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Fibonacci {

    private static final Logger LOGGER = Logger.getLogger(Fibonacci.class.getName());

    public static void main(String[] args) {
        int n = 10; // Change this value to compute a different Fibonacci number
        LOGGER.log(Level.INFO,"The fibonacci value of {0} numbers is : {1}",new Object[]{n,fib(n)});
    }

    public static int fib(int n){
        if (n==0 || n==1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
