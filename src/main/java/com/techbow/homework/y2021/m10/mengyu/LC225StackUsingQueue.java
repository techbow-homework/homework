package com.techbow.homework.y2021.m10.mengyu;

import java.util.LinkedList;
import java.util.Queue;

public class LC225StackUsingQueue {
    Queue<Integer> queue;


    public LC225StackUsingQueue() {
        queue = new LinkedList<>();
    }
    /// 1 2 3 4 5
    //   3 2 1
    public void push(int x) {
        queue.add(x);
        int k = queue.size()-1;
        for (int i = 0; i < k; i++) {
            //Integer firs = queue.remove();
            queue.add(queue.remove());
        }

    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
