package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m10.mengyu.ListNode;

import java.util.HashMap;

public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = dummy;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
