package com.techbow.homework.y2021.m10.kuixiaosu;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //corner case
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //时间复杂度：O（n）
}
