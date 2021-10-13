package com.techbow.homework.y2021.m10.Jacob;

import com.techbow.homework.y2021.m10.mengyu.ListNode;
/*
public class LC_24 {
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        ListNode cur;
        cur = new dummy;
        dummy.next = head;

        while (cur.next != null && cur.next.next != null) {
                ListNode first = cur.next;
                ListNode second = cur.next.next;
                cur.next = second;
                first.next = second.next;
                second.next = first;
                cur = cur.next.next;
        }
        return dummy.next;
    }
}

     */
