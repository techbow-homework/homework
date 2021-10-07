package com.techbow.homework.y2021.m10.mengyu;

public class LC2SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        /*
        cur = head;
        cur.next.next
        node->next
        */
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        ListNode rest = cur2.next;

        do{
            prev.next = cur2;
            cur2.next = cur1;
            cur1.next = rest;

            prev = cur1;
            cur1 = rest;
            cur2 = (cur1 != null) ? cur1.next : null;
            rest = (cur2 != null) ? cur2.next : null;
        } while (cur1 != null && cur1.next != null);
        return dummy.next;
    }
}
