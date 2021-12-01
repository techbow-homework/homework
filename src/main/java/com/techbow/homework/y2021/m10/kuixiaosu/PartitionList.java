package com.techbow.homework.y2021.m10.kuixiaosu;

public class PartitionList {
    public ListNode partitionList (ListNode head, int value) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curLess = dummy1;
        ListNode curLargeq = dummy2;
        while (cur != null) {
            if (cur.val < value) {
                curLess.next = cur;
                curLess = curLess.next;
            } else {
                curLargeq.next = cur;
                curLargeq = curLargeq.next;
            }
            cur = cur.next;
        }
        curLargerq.next = null;
        curLess.next = dummy2.next;
        return dummy1.next;
    }
}
