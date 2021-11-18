package com.techbow.homework.y2021.m10.kuixiaosu;

public class ReOrderList {
    public ListNode reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        return mergeList(leftHead, reverse(rightHead));
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        // corner case
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (cur1 != null && cur2 != null) {
            cur.next = cur1;
            cur = cur.next;
            cur1 = cur1.next;
            cur.next = cur2;
            cur = cur.next;
            cur2 = cur2.next;
        }
        cur.next = cur1;
        return dummy.next;
    }
}
