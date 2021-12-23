package com.techbow.homework.y2021.m10.rantao;

public class linkedListNov13 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null &&fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp;
        ListNode cur2 = slow.next;
        ListNode prev = null;

        while( cur2 != null){
            temp = cur2.next;
            cur2.next = prev;
            prev = cur2;
            cur2 = temp;
        }

        ListNode cur = head;
        cur2 = prev;

        while(cur2!= null) {
            temp = cur.next;
            cur.next = cur2;

            cur2 = cur2.next;
            cur.next.next = temp;
            cur = temp;
        }
        cur.next = null;

    }
}
