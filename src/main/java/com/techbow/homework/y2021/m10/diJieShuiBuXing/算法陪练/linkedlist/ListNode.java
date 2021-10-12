package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {

        return String.valueOf(val);
    }
}
