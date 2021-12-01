package com.techbow.homework.y2021.m11.QiyueWang;

public class LC82RemoveDuplictatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = dummy;
        ListNode prev = dummy;
        ListNode cur = head;

        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                prev.next = cur.next;
            }else{
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
