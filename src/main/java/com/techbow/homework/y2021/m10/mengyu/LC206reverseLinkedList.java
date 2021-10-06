package com.techbow.homework.y2021.m10.mengyu;

public class LC206reverseLinkedList {
        /*
    public ListNode reverseList(ListNode head) {
        //corner case
        if (head == null || head.next == null) return head;
        //recursion
        ListNode newHead = reverseList(head.next);
        //head.next --> newHead
        //newHead --> head
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    */

    public ListNode reverseList(ListNode head) {
        //TODO: corner case

        //iteration
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
