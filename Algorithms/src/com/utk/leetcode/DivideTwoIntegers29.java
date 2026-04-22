package com.utk.leetcode;

public class DivideTwoIntegers29 {

    static void main() {
        System.out.println(divide(2147483647, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        boolean sign = true;
        if (dividend < 0 && divisor > 0) sign = false;
        if (dividend > 0 && divisor < 0) sign = false;
        long quotient = 0;
        long numerator = dividend;
        numerator = Math.abs(numerator);
        long denominator = divisor;
        denominator = Math.abs(denominator);
        quotient = divideHelper(numerator, denominator,sign);
        return sign ? (int)quotient : (int)-quotient;
    }

    public static long divideHelper(long numerator, long denominator,boolean sign) {
        if(denominator>numerator) return 0;//dividend=10 divisor=3
        long quotient = 0;
        long power = 1;
        long result = 0;
        while (numerator >= denominator) {
            while ((denominator * power) <= numerator) {
                result = power;
                power *= 2;
            }
            numerator = numerator - (denominator * result);
            quotient += result;
            power = 1;
        }

        if(quotient>Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
        if(quotient>Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;
        return quotient;
    }
}
