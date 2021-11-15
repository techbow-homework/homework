package com.techbow.homework.y2021.m09.WooWooLily;

public class LC_206 {
    public ListNode reverseHead(ListNode head) {
        //recursive
        //1 -> 2 -> 3 -> 4 -> 5

        //base case
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseHead(head.next);
        // ask neighbors whats new head until it find last node

        head.next.next = head;
        head.next = null;
        //reverse itself
        return newHead;
    }


}
