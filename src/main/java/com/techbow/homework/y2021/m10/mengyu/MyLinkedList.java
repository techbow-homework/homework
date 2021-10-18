package com.techbow.homework.y2021.m10.mengyu;

public class MyLinkedList<E> {
    //fields
    MyListNode<E> head;
    MyListNode<E> tail;
    int size;
    //methods
    //constructor
    MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    E getVal(int index){
        MyListNode cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        if (cur == null) return null;
        return (E) cur.value;
    }
    void addHead (E val) {
        MyListNode<E> newHead = new MyListNode<>(val);
        if (tail == null) {
            tail = newHead;
        } else {
            head.prev = newHead;
            newHead.next = head;
        }
        head = newHead;
        size++;
    }
    void addTail (E val) {
        MyListNode<E> newTail = new MyListNode<>(val);
        if (head == null) {
            head = newTail;
        } else {
            tail.next = newTail;
            newTail.prev = tail;
        }
        tail = newTail;
        size++;
    }
    int getSize(MyListNode head) {
        return size;
    }

}

class MyListNode<E> {
    public E value;
    public MyListNode prev;
    public MyListNode next;

    public MyListNode(){
        this(null);
    };
    public MyListNode(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
    public MyListNode(E value, MyListNode next, MyListNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    };
}
