package com.techbow.homework.y2021.m11.QiyueWang;

public class LC19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode fast = head;
        ListNode cur = head;
        ListNode prev = new ListNode();
        prev.next = cur;
        while(fast != null){
            fast = fast.next;
            count++;
            if(count < n){
                continue;
            }
            if(fast == null) {
                if(count == 1) return null;// only one node
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        //System.out.println(prev.val + " " + cur.val +" " );
        if(cur == head) return cur.next;// head been deleted
        prev.next = cur.next;
        return head;
    }
}
