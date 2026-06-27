package com.utk.leetcode;

import java.util.Arrays;

public class Problem860 {

    static void main() {
        int[] bills = {5,5,10,10,5,20,5,10,5,5};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int[] currencyNotes = new int[3];
        boolean possibility = true;
        for (int bill : bills) {
            if (bill == 5) {
                System.out.println("Bill received : " + bill);
                currencyNotes[0]++;
                System.out.println("Currency notes : " + Arrays.toString(currencyNotes));
            } else {
                System.out.println("Bill received : " + bill);
                if (!isDenExchangePoss(currencyNotes, bill - 5)) return false;
            }
        }
        return possibility;
    }

    public static boolean isDenExchangePoss(int[] currencyNotes, int moneyToBeReturned) {
        boolean result = true;
        if (moneyToBeReturned >= 10) {
            if (currencyNotes[0] > 0 && currencyNotes[1] > 0) {
                System.out.println("Money to be returned : " + moneyToBeReturned);
                System.out.println("Currency notes before  returning : "+ Arrays.toString(currencyNotes));
                currencyNotes[0]--;
                currencyNotes[1]--;
                currencyNotes[2]++;
                System.out.println("Currency notes after returning : " + Arrays.toString(currencyNotes));
            } else if (currencyNotes[0] >= 3) {
                System.out.println("Money to be returned : " + moneyToBeReturned);
                System.out.println("Currency notes before  returning : "+ Arrays.toString(currencyNotes));
                currencyNotes[0] -= 3;
                currencyNotes[2]++;
                System.out.println("Currency notes after returning : " + Arrays.toString(currencyNotes));
            } else {
                System.out.println("Not able to return as currency notes : " + Arrays.toString(currencyNotes));
                return false;
            }
        } else {
            if (currencyNotes[0] >= 1) {
                System.out.println("Money to be returned : " + moneyToBeReturned);
                System.out.println("Currency notes before  returning : "+ Arrays.toString(currencyNotes));
                currencyNotes[0]--;
                currencyNotes[1]++;
                System.out.println("Currency notes after returning : " + Arrays.toString(currencyNotes));
            } else {
                System.out.println("Not able to return as currency notes : " + Arrays.toString(currencyNotes));
                return false;
            }
        }
        return result;
    }
}
