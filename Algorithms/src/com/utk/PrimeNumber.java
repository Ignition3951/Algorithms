package com.utk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrimeNumber {

    private static final Logger LOGGER = Logger.getLogger(PrimeNumber.class.getName());

    public static void main(String[] args) {
        int n = 8;
        LOGGER.log(Level.INFO, "Is {0} a prime number? {1}", new Object[]{n, isPrime(n)});
    }

    public static boolean isPrime(int n) {
        int count =0;
        if(n==1 || n==2){
            return true;
        }
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
            if(count==3){
                return false;
            }
        }
        return true;
    }
}
