package com.utk.leetcode;

import java.util.Arrays;

public class CountPrime204 {

    static void main() {
        System.out.println(countPrimes(3));
    }

    public static int countPrimes(int n) {
        int count = 0;
        int[] primes = new int[n + 1];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = 0;
                }
            }
        }

        for (int k=0; k < primes.length-1; k++) {
            if (primes[k] == 1) {
                count++;
            }
        }
        return count;
    }
}
