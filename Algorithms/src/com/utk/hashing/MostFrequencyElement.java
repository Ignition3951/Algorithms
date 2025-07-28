package com.utk.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MostFrequencyElement {

    private static final Logger LOGGER = Logger.getLogger(MostFrequencyElement.class.getName());

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 3};
        LOGGER.log(Level.INFO, "Most frequent element is: {0}", mostFrequency(arr));
    }

    public static int mostFrequency(int[] num) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        for (int j : num) {
            frequencyMap.put(j, frequencyMap.getOrDefault(j, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> set : frequencyMap.entrySet()) {
            if (set.getValue() > max)
                max = set.getKey();
        }
        return max;
    }
}
