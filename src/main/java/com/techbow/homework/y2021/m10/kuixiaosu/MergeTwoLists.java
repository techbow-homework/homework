package com.techbow.homework.y2021.m10.kuixiaosu;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        // corner case
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode cur = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        cur = head;
        while （l1 != null && l2 != null）{
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
// post processing
        if (l1 == null) cur.next = l2;
        else cur.next = l1;
        return head;
    }
}
