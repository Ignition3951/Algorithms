package com.utk.leetcode.problem225;

import java.util.LinkedList;
import java.util.Queue;

//Implement Stack using Queues
public class Problem225 {

    Queue<Integer> queue;
    public Problem225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);

        for(int i=1;i<queue.size();i++){
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.poll();
    }

    public int top() {
        if(queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
