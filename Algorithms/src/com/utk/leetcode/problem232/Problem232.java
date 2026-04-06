package com.utk.leetcode.problem232;

import java.util.Stack;

public class Problem232 {

    Stack<Integer> originalStack;
    Stack<Integer> modifiedStack;
    public Problem232() {
        originalStack = new Stack<>();
        modifiedStack = new Stack<>();
    }

    void push(int x) {//1,2,3,4,5
        while(!modifiedStack.isEmpty()){
            originalStack.push(modifiedStack.pop());
        }
        originalStack.push(x);
        while(!originalStack.isEmpty()){
            modifiedStack.push(originalStack.pop());
        }
    }

    int pop() {
       return modifiedStack.pop();
    }

    int peek() {
        return modifiedStack.peek();
    }

    boolean empty() {
        return modifiedStack.isEmpty();
    }
}
