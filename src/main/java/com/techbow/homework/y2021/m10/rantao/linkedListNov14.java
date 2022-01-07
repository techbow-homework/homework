package com.techbow.homework.y2021.m10.rantao;

public class linkedListNov14 {
    public ListNode plusOne(ListNode head) {

        ListNode addition = new ListNode(1);
        ListNode newHead = reverse(head);
        ListNode cur = newHead;

        while(cur != null){
            if(cur.val == 9){
                cur.val =0;
                cur = cur.next;
            }else {
                cur.val = cur.val +1;
                break;
            }
        }
        newHead = reverse(newHead);
        if(newHead.val == 0) {
            addition.next = newHead;
            return addition;
        }else return newHead;

    }

    ListNode reverse(ListNode head){
        ListNode temp;
        ListNode cur = head;
        ListNode prev = null;

        while(cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
