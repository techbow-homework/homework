package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;



public class LC19RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode s = head, f = head;

        for(int i = 0 ; i < n; i++){
            if(f == null){
                return head;
            }
            f = f.next;
        }

        if(f == null){ //case [1] 1
            return head.next;
        }

        while(f !=null && f.next != null){
            s = s.next;
            f = f.next;
        }

        ListNode next = s.next.next;
        s.next.next = null;
        s.next = next;

        return head;

    }
}
