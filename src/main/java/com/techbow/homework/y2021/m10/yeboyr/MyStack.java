package com.techbow.homework.y2021.m10.yeboyr;

public class MyStack<T> {
    //fields
    private ListNode<T> head;

    //methods

    public MyStack(){
        head = null;
    }

    public void push(T item){
        ListNode<T> newNode = new ListNode<T>();
        newNode.next = head;
        head = newNode;

    }

    public T pop(){
        if (head==null) return null;
        ListNode<T> popNode = head;
        head = head.next;
        popNode.next = null;
        return popNode.value;
    }

    public T peek(){
        return head == null? null:head.value;
    }
}


