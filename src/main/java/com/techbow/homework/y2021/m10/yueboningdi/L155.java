import java.util.EmptyStackException;
import java.util.Stack;


/*
L155. Min Stack
 */
public class L155 {
    //solution 1_1
    class MinStack_1_1 {    //TODO: Generics
        //fields
        private Stack<Integer> stack_ele;
        private Stack<Integer> stack_min;

        //methods
        public MinStack_1_1() {
            stack_ele = new Stack<Integer>();
            stack_min = new Stack<Integer>();
        }

        public void push(int val) {
            stack_ele.push(val);
            if (stack_min.empty() || val <= stack_min.peek()){
                stack_min.push(val);
            }else{
                stack_min.push(stack_min.peek());
            }
        }

        //leetcode requires a void function, but it should be return Integer function
        public void pop() {
            //corner case
            if (stack_ele.empty()){
                throw new EmptyStackException();
            }
            stack_min.pop();
            stack_ele.pop();
            return;
        }

        public int top() {
            //corner case
            if (stack_ele.empty()){
                throw new EmptyStackException();
            }
            return stack_ele.peek();
        }

        public int getMin() {
            //corner case
            if (stack_ele.empty()){
                throw new EmptyStackException();
            }
            return stack_min.peek();
        }
    }

    //solution 1_2
//    class MinStack {    //TODO:Generics
//        public static Pair <Integer,Integer>
//        //fields
//        private Stack<Pair> stack;
//
//        //methods
//        public MinStack() {
//
//        }
//
//        public void push(int val) {
//
//        }
//
//        public void pop() {
//
//        }
//
//        public int top() {
//
//        }
//
//        public int getMin() {
//
//        }
//    }

    //solution 2
    class MinStack {
        //fields
        private Stack<Integer> stack_ele;
        private Stack<Integer> stack_min;

        //methods
        public MinStack() {
            stack_ele = new Stack<Integer>();
            stack_min = new Stack<Integer>();
        }

        public void push(int val) {
            stack_ele.push(val);
            if (stack_min.empty() || val <= stack_min.peek()){
                stack_min.push(val);
            }
            return;
        }

        public void pop() {
            if (stack_ele.empty()){
                throw new EmptyStackException();
            }
            if (stack_ele.peek().equals(stack_min.peek())){
                stack_min.pop();
            }
            stack_ele.pop();
        }

        public int top() {
            if (stack_ele.empty()) {
                throw new EmptyStackException();
            }
            return stack_ele.peek();
        }

        public int getMin() {
            if (stack_ele.empty()) {
                throw new EmptyStackException();
            }
            return stack_min.peek();
        }
    }

}