package com.techbow.homework.y2021.m10.mengyu;

public class ListNode<E> {
    public E val;
    public ListNode next;
    public ListNode prev;
    public ListNode() {}
    public ListNode(E val) { this.val = val; }
    public ListNode(E val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev = prev;}
}
