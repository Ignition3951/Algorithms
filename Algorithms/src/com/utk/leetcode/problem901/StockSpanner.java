package com.utk.leetcode.problem901;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {

    Stack<Integer> stack;
    List<Integer> spanner;
    int counter;
    public StockSpanner() {
        stack = new Stack<>();
        spanner = new ArrayList<>();
        counter = 0;
    }

    public int next(int price) {
        int location=0;
        int count=1;
        while(!stack.isEmpty() && stack.peek()<=price){
            stack.pop();
            location  += spanner.get(spanner.size()-1-location);

        }
        count+=location;
        stack.push(price);
        spanner.add(count);
        return count;
    }
}
