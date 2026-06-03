package com.algo.abdulbari.greedy.util;

import com.algo.abdulbari.greedy.model.Job;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getProfit() > o2.getProfit()) {
            return -1; // o1 has a higher profit
        } else if (o1.getProfit() < o2.getProfit()) {
            return 1; // o2 has a higher profit
        }
        return 0; // profits are equal
    }
}
