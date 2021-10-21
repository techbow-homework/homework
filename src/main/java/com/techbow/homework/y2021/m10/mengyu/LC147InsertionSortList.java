package com.techbow.homework.y2021.m10.mengyu;

public class LC147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = null;
        ListNode curr = head;
        while (curr != null) {
            int val = curr.val;
            newHead = insert(newHead, val);
            curr = curr.next;
        }
        return newHead;
    }

    public ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        if (newNode.val <= head.val) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.val <= newNode.val) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}
