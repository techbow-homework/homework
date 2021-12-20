package com.techbow.homework.y2021.m12QiyueWang;

public class LC2095DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = new ListNode();
        while(fast != null){
            if(fast.next == null){
                break;
            }
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = slow.next;
        slow.next = null;
        return head;
    }
}
