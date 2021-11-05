package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m10.mengyu.ListNode;

public class StackUsingLinkedList<E> {
    //field
    private ListNode<E> head;
    //methods
    //constructor
    public StackUsingLinkedList(){
        head = null;
    }
    //push
    public void push(E val){
        ListNode<E> newHead = new ListNode<>(val);
        if (head == null) {
            head = newHead;
            head.next = null;
        } else {
            newHead.next = head;
            head = newHead;
        }
    }
    //pop
    public E pop() {
        if (head == null) return null;
        ListNode<E> popNode = head;
        head.next = head;
        popNode.next = null;
        return popNode.val;
    }
    //peek
    public E peek() {
        return head == null ? null : (E) head.val;
    }
}
