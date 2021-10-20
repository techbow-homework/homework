package com.techbow.homework.y2021.m10.mengyu;

import java.util.Stack;

public class LC155minStack {
    //one stack with Value, Min pair
    class MinStack {
        Stack<int[]> stackPair;
        public MinStack() {
            stackPair = new Stack();
        }

        public void push(int val) {
            if (stackPair.isEmpty()) {
                stackPair.push(new int[]{val, val});
                return;
            }
            int currentMin = stackPair.peek()[1];
            stackPair.push(new int[]{val, Math.min(val, currentMin)});
        }

        public void pop() {
            stackPair.pop();
        }

        public int top() {
            return stackPair.peek()[0];
        }

        public int getMin() {
            return stackPair.peek()[1];
        }
    }
/*
two stacks
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public MinStack() { }


    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }


    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }


    public int top() {
        return stack.peek();
    }


    public int getMin() {
        return minStack.peek();
    }
}
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
