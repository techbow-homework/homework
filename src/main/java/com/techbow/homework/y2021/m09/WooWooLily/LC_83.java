package com.techbow.homework.y2021.m09.WooWooLily;

public class LC_83 {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }

        return head;
    }

}
