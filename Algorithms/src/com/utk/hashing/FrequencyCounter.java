package com.utk.hashing;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrequencyCounter {

    private static final Logger LOGGER = Logger.getLogger(FrequencyCounter.class.getName());

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 5};
        LOGGER.log(Level.INFO, "Frequencies are as displayed : {0}", countFrequencies(arr));
    }

    public static List<List<Integer>> countFrequencies(int[] arr) {
        int size = arr.length;
        List<List<Integer>> frequencyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> frequencySubList = new ArrayList<>();
            int count = 0;
            int temp = arr[i];
            for (int j = 0; j < size; j++) {
                if (arr[j] != -1 && temp == arr[j]) {
                    count++;
                    arr[j] = -1;
                }
            }
            if (count != 0) {
                frequencySubList.add(temp);
                frequencySubList.add(count);
                frequencyList.add(frequencySubList);
            }

        }
        return frequencyList;
    }
}
