package com.techbow.homework.y2021.m10.kuixiaosu;

public class InsertLinkedList {
    public ListNode insertList(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        //pre processing
        if (head == null || val <= head.val) {
            newNode.next = head;
            return newNode;
        }
        ListNode prev = head;

        while (prev.next != null && prev.next.val < val) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
}
