package com.utk.recursion;

public class Power {

    static void main() {
        double x = 2.00;
        int n = -2;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            if(n==Integer.MIN_VALUE){
                return myPow(x,Integer.MAX_VALUE);
            }
            n *= -1;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

}
