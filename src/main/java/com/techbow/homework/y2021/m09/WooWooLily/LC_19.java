package com.techbow.homework.y2021.m09.WooWooLily;

public class LC_19 {
    //remove Nth node from list end

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast != null) {
            if (n-- >= 0 ) {
                fast = fast.next;
            }
            else {
                slow = slow.next;
                fast = fast.next;

            }
        }

        ListNode next = slow.next;
        slow.next = next.next;
        next = null; //GC

        return dummy.next;

    }

}
