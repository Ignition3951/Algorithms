package com.utk.recursion;

public class GoodNumber {

    static final int modulo = 1000000007;

    static void main() {
        int goodNumbers = countGoodNumbers(50);
        System.out.println(goodNumbers);
    }

    static int countGoodNumbers(long n) {
        int evenPositions = (int) ((n+1)/2);
        int oddPositions = (int) n/2;
        long evenCounts = fastPower(5, evenPositions);
        long oddCounts = fastPower(4, oddPositions);
        return (int)((evenCounts * oddCounts) % modulo);
    }

    static long fastPower(int base,int exponent){
       if(exponent==0){
           return 1;
       }
       long half = fastPower(base,exponent/2) % modulo;
       if(exponent%2==0){
           return (half * half) % modulo;
       }else{
           return (base * half * half) % modulo;
        }

    }
}
