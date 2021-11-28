package com.techbow.homework.y2021.m10.kuixiaosu;

public class MyStackUsingLinkedList {
    public class MyStack<T>{  //TODO: Generics
        // fields
        private ListNode<T> head;

        //methods
        public MyStack(){
            head = null;
        }
        public void push(T val){
            ListNode<T> newNode = new ListNode<T>(val);
            newNode.next = head;
            head = newNode;
        }

        public T pop() {
            if(head == null) return null;
            ListNode<T> temp = head;
            head = head.next;
            temp.next = null; //标准singly linkedlist 需要断开，而且需要启动GC
            return temp.val;
        }
        public T peek() {
            if (head == null) return null;
            return head.val;
        }
    }
}
