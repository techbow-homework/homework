package com.techbow.homework.y2021.m10.mengyu;

public class LC876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
