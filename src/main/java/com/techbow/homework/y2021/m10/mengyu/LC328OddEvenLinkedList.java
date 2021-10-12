package com.techbow.homework.y2021.m10.mengyu;

public class LC328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        //corner case
        if (head == null) return null;

        ListNode tail = head;
        int counter = 0;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        ListNode curr = head;
        ListNode even = null;
        while (curr != null && curr.next != null && counter < size / 2) {
            even = curr.next;

            curr.next = curr.next.next;
            tail.next = even;
            even.next = null;

            curr = curr.next;
            counter++;
            tail = tail.next;
        }
        return head;
    }
}
