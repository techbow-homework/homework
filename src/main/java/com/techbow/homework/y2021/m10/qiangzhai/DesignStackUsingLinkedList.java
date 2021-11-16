package com.techbow.homework.y2021.m10.qiangzhai;

public class DesignStackUsingLinkedList {
    public Class MyStack<T> {
        //fields
        private ListNode<T> head;
        //methods
        //constructor
	public MyStack() {
            head = null;
        }
        //push
        public void push(T item) {
            ListNode<T> newNode = new ListNode<T> item;
            newNode.next = head;
            head = newNode;
        }
        //pop
        public T pop() {
            //cc
            if (head == null) return null;
            ListNode<T> popNode = head;
            head = head.next;
            popNode.next = null;//for GC purpose
            return popNode.item;
        }
        //peek
        public T peek() {
            return head == null ? null : head.item;
        }
    }
//其中在peek的时候，如果head的值就是null，那怎么判断这里的null是什么意思？
//可以用try&catch block，然后throweexception来做
}
