package com.techbow.homework.y2021.m11.mengyu;

import com.techbow.homework.y2021.m10.mengyu.ListNode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
