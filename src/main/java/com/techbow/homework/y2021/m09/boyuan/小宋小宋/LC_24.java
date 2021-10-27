package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
}
