package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m10.mengyu.ListNode;

public class QueueUsingLinkedList<E> {
    //field
    private ListNode<E> head;
    private ListNode<E> tail;
    //methods
    //constructor
    public QueueUsingLinkedList(){
        head = null;
        tail = null;
    }
    //offer
    public void offer (E val) {
        ListNode<E> newNode = new ListNode<>(val);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    //poll
    public E poll() {
        if (head == null) {
            return null;
        }
        ListNode<E> polledNode = head;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            polledNode.next = null;
        }
        return polledNode.val;
    }
    //peek
    public E peek() {
        if (head == null) return null;
        return head.val;
    }
}
