package com.utk.leetcode.problem901;


import java.util.Arrays;
import java.util.List;

public class StockSpannerImpl {

    static void main() {

        StockSpanner stockSpanner =null;
        List<String> operations = Arrays.asList("StockSpanner","next","next","next","next","next","next","next","next","next","next");
        List<List<Integer>> values =  Arrays.asList(
                List.of(),
                List.of(73),
                List.of(99),
                List.of(41),
                List.of(68),
                List.of(32),
                List.of(22),
                List.of(72),
                List.of(1),
                List.of(83),
                List.of(75)
        );

        for (int i = 0; i < operations.size(); i++) {
            switch (operations.get(i)) {
                case "StockSpanner":
                    stockSpanner = new StockSpanner();
                    break;
                case "next":
                    assert stockSpanner != null;
                    int value = stockSpanner.next(values.get(i).getFirst());
                    System.out.println(value);
                    break;
            }
        }

    }
}
