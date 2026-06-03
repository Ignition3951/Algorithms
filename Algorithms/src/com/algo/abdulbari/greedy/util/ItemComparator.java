package com.algo.abdulbari.greedy.util;

import com.algo.abdulbari.greedy.model.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        BigDecimal ratio1 = BigDecimal.valueOf(
                        o1.getProfit())
                .divide(BigDecimal.valueOf(o1.getWeight())
                        , 2, RoundingMode.HALF_UP);
        BigDecimal ratio2 = BigDecimal.valueOf(
                        o2.getProfit())
                .divide
                        (BigDecimal.valueOf(o2.
                                getWeight()), 2, RoundingMode.HALF_DOWN);
        if (ratio1.compareTo(ratio2) > 0) {
            return -1; // o1 has a higher ratio
        } else if (ratio1.compareTo(ratio2) < 0) {
            return 1; // o2 has a higher ratio
        }
        return 0;
    }
}
