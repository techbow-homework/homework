package com.techbow.homework.y2021.m10.qiangzhai;

public class DesignQueueUsingLinkedList {
    ```java
    public class MyQueue<E> {
        //fields
        private ListNode<E> head, tail;
        int length;
        //method
        public MyQueue() {
            head = null;
            tail = null;
            length = 0;
        }
        //
        public void offer(E val) {
            if (tail == null) {
                tail = new ListNode<>(val);
                head = tail;
            } else {
                ListNode<E> newTail = new ListNode<>(val);
                tail.next = newTail;
                newTail.prev = tail;
                tail = newTail;
            }
            length++;
        }
        //
        public E poll() {
            //cc
            if (head == null) return null;
            ListNode<E> temp = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
            length--;
            return temp.val;
        }
        //
        public E peek() {
            return head == null ? null : head.val;
        }
    }
```
}
