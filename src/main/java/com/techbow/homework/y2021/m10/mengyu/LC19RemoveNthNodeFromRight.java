package com.techbow.homework.y2021.m10.mengyu;

public class LC19RemoveNthNodeFromRight {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //TODO: corner cases
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            size += 1;
        }

        int fromLeft = size - n;
        ListNode target = head;
        ListNode prev = new ListNode();
        //edge case
        if (fromLeft == 0) {
            ListNode newHead = head.next;
            return newHead;
        } else {
            while (fromLeft > 0) {
                prev = target;
                target = target.next;
                fromLeft--;
            }
            ListNode targetNext = target.next;
            target.next = null;
            prev.next = targetNext;
            return head;
        }
    }
}
