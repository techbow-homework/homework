package com.techbow.homework.y2021.m10.kuixiaosu;

public class MyQueueUsingStack {
    public class MyQueue<T> implements Queue {
        //fields
        private Stack<T> stackIn;
        private Stack<T> stackOut;

        //methods
        public MyQueue() {
            stackIn = new stack<T>();
            stackOut = new stack<T>();
        }
        public void offer(T val){
            stackIn.push(val);
        }
        public T poll(){
            move();
            return stackOut.isEmpty() ? null : stackOut.pop();
        }
        public T peek(){
            move();
            return stackOut.isEmpty() ? null : stackOut.peek();
        }

        private T move(){
            if(stackOut.isEmpty()) {
                while (!stackIn.isEmpty()){
                    stackOut.push(stackIn.pop());
                }
            }
        }
    }
}
