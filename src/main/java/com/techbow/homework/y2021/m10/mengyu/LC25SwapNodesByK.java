package com.techbow.homework.y2021.m10.mengyu;

public class LC25SwapNodesByK {
    public ListNode reverseLinkedList (ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while (k > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;

        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverseLinkedList(head, k);
            head.next = reverseKGroup(temp, k);
            return reversedHead;
        }
        return head;
    }
}
