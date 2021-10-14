package com.techbow.homework.y2021.m10.mengyu;

public class LC92ReverseLinkedListByRange {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //corner case
        if (head == null) {
            return null;
        }

        ListNode cur = head, prev = null;
        while (left > 1) {
            prev = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode subHead = prev, subTail = cur;
        ListNode next = null;
        while (right > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            right--;
        }
        if (subHead != null) {
            subHead.next = prev;
        } else {
            head = prev;
        }

        subTail.next = cur;
        return head;
    }
}
