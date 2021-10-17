package com.techbow.homework.y2021.m10.mengyu;

import java.util.Queue;
import java.util.Stack;

public class LC232MyQueueWithStack {
    /*
    1 2 3 4 5
    stack 1 2 3
    stack 3 2
    */
    //field
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public LC232MyQueueWithStack() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        move();
        return stackOut.isEmpty() ? null : stackOut.pop();
    }

    public int peek() {
        move();
        return stackOut.isEmpty() ? null : stackOut.peek();
    }
    public void move() {
        if (stackOut.isEmpty()) {
            while(!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

}

