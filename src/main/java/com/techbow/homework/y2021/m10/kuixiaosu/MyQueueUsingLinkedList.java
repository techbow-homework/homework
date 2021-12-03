package com.techbow.homework.y2021.m10.kuixiaosu;

public class MyQueueUsingLinkedList {
    public class MyQueue<E>{
        //fields
        private ListNode<E> head;
        private ListNode<E> tail;
        //methods
        public MyQueue() {
            head = null;
            tail = null;
        }
        public void offer(E val) {
            ListNode<E> newNode = new ListNode<E>(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        public E poll() {
            if (head == null) return null;
            ListNode<E> temp = head;
            if (head == tail) {
                head == null;
                tail == null;
            } else {
                head = head.next;
                head.prev = null;
                temp.next = null;
            }
            return temp.val;
        }

        public E peek() {
            if (head == null) return null;
            return head.val;
        }
    }
}
