import java.util.LinkedList;
import java.util.Queue;

/*
L225. Implement Stack using Queues
 */
public class L225 {

    //solution 1.1: 2 queue solution
    //Time Complexity: push O(1), pop&peek O(n).
    class MyStack_1_1 {
        //fields
        Queue<Integer> QueueInOut;
        Queue<Integer> QueueHelper;

        //methods
        /** Initialize your data structure here. */
        public MyStack_1_1() {
            QueueInOut = new LinkedList<Integer>();
            QueueHelper = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            QueueInOut.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            //corner case
            if (QueueInOut == null || QueueInOut.isEmpty()){
                throw new IllegalArgumentException("NUll/Empty stack!");
            }
            //normal case
            int n = QueueInOut.size();
            for (int i = 0; i < n - 1; i++){
                QueueHelper.offer(QueueInOut.poll());
            }
            int ans = QueueInOut.poll();
            Queue<Integer> tmp = QueueInOut;
            QueueInOut = QueueHelper;
            QueueHelper = tmp;
            return ans;
        }

        /** peek(): Get the top element. */
        public int top() {
            //corner case
            if (QueueInOut == null || QueueInOut.isEmpty()){
                throw new IllegalArgumentException("NUll/Empty stack!");
            }
            //normal case
            int n = QueueInOut.size();
            for (int i = 0; i < n - 1; i++){
                QueueHelper.offer(QueueInOut.poll());
            }
            int ans = QueueInOut.peek();
            QueueHelper.offer(QueueInOut.poll());
            Queue<Integer> tmp = QueueInOut;
            QueueInOut = QueueHelper;
            QueueHelper = tmp;
            return ans;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return QueueInOut.isEmpty();
        }
    }

    //solution 1.2: 2 queue solution
    //Time Complexity: push O(n), pop&peek O(1).
    class MyStack_1_2 {
        //fields
        Queue<Integer> QueueInOut;
        Queue<Integer> QueueHelper;

        //methods
        public MyStack_1_2() {
            QueueInOut  = new LinkedList<Integer>();
            QueueHelper = new LinkedList<Integer>();
        }

        public void push(int x) {
            //corner case
            if (QueueInOut.isEmpty()){
                QueueInOut.offer(x);
                return;
            }
            //normal case
            QueueHelper.offer(x);
            while (!QueueInOut.isEmpty()){
                QueueHelper.offer(QueueInOut.poll());
            }
            Queue<Integer> tmp = QueueInOut;
            QueueInOut = QueueHelper;
            QueueHelper = tmp;
            return;
        }

        public int pop() {
            //corner case
            if (QueueInOut.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot pop!");
            }
            //normal case
            return QueueInOut.poll();
        }

        public int top() {
            //corner case
            if (QueueInOut.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot peek!");
            }
            //normal case
            return QueueInOut.peek();
        }

        public boolean empty() {
            return QueueInOut.isEmpty();
        }
    }

    //solution 2_1: 1 queue solution (put the new element at the end of the queue)
    //Time Complexity: push O(1), pop&peek O(n).
    class MyStack_2_1 {
        //fields
        Queue<Integer> myQueue;

        //methods
        public MyStack_2_1() {
            myQueue  = new LinkedList<Integer>();
        }

        public void push(int x) {
            myQueue.offer(x);
            return;
        }

        public int pop() {
            //corner case
            if (myQueue.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot pop!");
            }
            //normal case
            for (int i = 0; i < myQueue.size() - 1; i++){
                myQueue.offer(myQueue.poll());
            }
            return myQueue.poll();
        }

        //peek()
        public int top() {
            //corner case
            if (myQueue.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot pop!");
            }
            //normal case
            for (int i = 0; i < myQueue.size() - 1; i++){
                myQueue.offer(myQueue.poll());
            }
            int ans = myQueue.peek();
            myQueue.offer(myQueue.poll());
            return ans;
        }

        public boolean empty() {
            return myQueue.isEmpty();
        }
    }

    //solution 2_2: 1 queue solution (put the new element at the head of the queue)
    //Time Complexity: push O(n), pop&peek O(1).
    class MyStack {
        //fields
        Queue<Integer> myQueue;

        //methods
        public MyStack() {
            myQueue  = new LinkedList<Integer>();
        }

        private void moveNewToHead(int newElem){
            myQueue.offer(newElem);
            for (int i = 0; i < myQueue.size() - 1; i++){
                myQueue.offer(myQueue.poll());
            }
            return;
        }

        public void push(int x) {
            //corner case
            if (myQueue.isEmpty()){
                myQueue.offer(x);
                return;
            }
            //normal case
            moveNewToHead(x);
            return;
        }

        public int pop() {
            //corner case
            if (myQueue.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot pop!");
            }
            //normal case
            return myQueue.poll();
        }

        public int top() {
            //corner case
            if (myQueue.isEmpty()){
                throw new IllegalArgumentException("Empty stack cannot peek!");
            }
            //normal case
            return myQueue.peek();
        }

        public boolean empty() {
            return myQueue.isEmpty();
        }
    }
}
