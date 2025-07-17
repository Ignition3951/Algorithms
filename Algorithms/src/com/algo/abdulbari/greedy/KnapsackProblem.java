package com.algo.abdulbari.greedy;

import com.algo.abdulbari.greedy.model.Item;
import com.algo.abdulbari.greedy.util.ItemComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KnapsackProblem {

    private static final Logger LOGGER = Logger.getLogger(KnapsackProblem.class.getName());

    public static void main(String[] args) {

        Item item1 = new Item("Item1", 10, 60);
        Item item2 = new Item("Item2", 20, 100);
        Item item3 = new Item("Item3", 30, 120);
        Item item4 = new Item("Item4", 30, 240);
        int bagWeight = 50;
        Item[] items = {item1, item2, item3, item4};
        ArrayList<Item> baggedItems = new ArrayList<>();
        Arrays.sort(items, new ItemComparator());
        LOGGER.log(Level.INFO, "Sorted array is : {0}", Arrays.toString(items));
        for (Item item : items) {
            if (bagWeight > 0) {
                if ((bagWeight - item.getWeight()) >= 0) {
                    baggedItems.add(item);
                    bagWeight -= item.getWeight();
                } else {
                    item.setWeight(bagWeight);
                    baggedItems.add(item);
                    bagWeight = 0;
                }
            }
        }
        LOGGER.log(Level.INFO, "Bagged array is : {0}", baggedItems);

    }
}
