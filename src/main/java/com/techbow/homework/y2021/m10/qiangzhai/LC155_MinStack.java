package com.techbow.homework.y2021.m10.qiangzhai;

public class LC155_MinStack {
    //S1: using two stacks
    public class MinStack {//TODO: Generics
        //fields
        private Stack<Integer> stack_ele;//<>里面是class，对应primitive wrapper class Integer
        private Stack<Integer> stack_min;
        //methods
        public MinStack() {
            stack_ele = new Stack<Integer>();
            stack_min = new Stack<Integer>();
        }

        public void push(int val) {
            stack_ele.push(val);
            if (stack_min.isEmpty() || stack_min.peek() >= val) stack_min.push(val);
            else stack_min.push(stack_min.peek());
        }

        public Integer pop() {
            //cc 有可能pop/top/get 不出来，所以要先检查是否为空！
            if (stack_ele.isEmpty()) return null;
            stack_min.pop();
            return stack_ele.pop();
        }

        public Integer top() {
            //cc
            if (stack_ele.isEmpty()) return null;
            return stack_ele.peek();
        }

        public Integer getMin() {
            //cc
            if (stack_min.isEmpty()) return null;
            return stack_min.peek();
        }
    }
    //S2: using one stack
    class MinStack {
        private Stack<Node> stack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<Node>();
        }

        public void push(int val) {
            int cur = val;
            int minValue = (stack.isEmpty() || stack.peek().min >= val) ? val : stack.peek().min;
            stack.push(new Node(cur, minValue));
        }

        public Integer pop() {//以下类似，cache pop出来的node，return其value！
            if (stack.isEmpty()) return null;
            Node node = stack.pop();
            return node.val;
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek().val;
            }else return 0;
        }

        public int getMin() {
            if (!stack.isEmpty()) {
                return stack.peek().min;
            }else return 0;
        }

        private class Node {
            //fields
            int val;
            int min;
            //methods
            private Node (int v, int m) {
                this.val = v;
                this.min = m;
            }
        }
    }
}
