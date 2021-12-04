package com.techbow.homework.y2021.m10.yeboyr;

public class Mylist<T> {
    //fields
    T value;
    ListNode<T> head;
    ListNode<T> tail;
    int size;

    public Mylist(){
        T value = null;
        head = null;
        tail = null;
        size = 0;

    }

    public void addHead(T value) {
        ListNode<T> newHead = new ListNode<>();
        if (head == null) {
            tail = newHead;
        } else {
            newHead.next = head;
            head.previous = newHead;
        }

        head = newHead;
    }

    public void addTail(T value){
        ListNode<T> newTail = new ListNode<>();
        if(tail == null){
            tail = newTail;
        } else {
            tail.next = newTail;
            newTail.previous = tail;
        }
        tail = newTail;
        size++;
    }

    public int getSize(){
        return size;
    }
}


