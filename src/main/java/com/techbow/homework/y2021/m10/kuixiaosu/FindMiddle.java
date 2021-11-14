package com.techbow.homework.y2021.m10.kuixiaosu;

public class FindMiddle {
    public ListNode findMiddle(ListNode head) {
        //corner case
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
