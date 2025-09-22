package com.utk.recursion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RecursiveFactorial {

    private static final Logger LOGGER = Logger.getLogger(RecursiveFactorial.class.getName());

    public static void main(String[] args) {
        int n=5;
        LOGGER.log(Level.INFO,"The factorial of {0} is : {1}",new Object[]{n,factorial(n)});
    }

    public static int factorial(int n){
        int result=n;
        if(n>1){
            result = result * factorial(n-1);
        }
        return result;
    }
}
