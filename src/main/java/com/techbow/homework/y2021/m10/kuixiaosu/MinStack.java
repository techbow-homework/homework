package com.techbow.homework.y2021.m10.kuixiaosu;

public class MinStack<T> {
    //fields
    private Stack<T> stack1;
    private Stack<T> stack2;
    


    //methods
    public MinStack(){
        stack1 = new stack<T>();
        stack2 = new stack<T>();
    }
    public void push( T val) {
        stack1.push(val);
        if (stack2.isEmpty() || stack2.peek() >= val) {
            stack2.push(val);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public T pop () {
        if (stack1.isEmpty) {
            return null;
        } else {
            stack2. pop();
            return stack1. pop();
        }
    }
    public T min() {
        if(stack2.isEmpty()) {
            return null;
        } else {
            return stack2.peek();
        }
    }

    public T top(){
        if (stack1.isEmpty) {
            return null;
        } else {
            return stack1.top();
        }
    }
}
