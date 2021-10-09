package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode a = head, b = head;
        boolean intersection = false;

        while( b.next!= null && b.next.next != null){

            a = a.next;
            b = b.next.next;
            if(a == b){
                intersection = true;
                break;
            }
        }

        if(!intersection){
            return null;
        }

        b = head;
        while(b != a){
            a = a.next;
            b = b.next;
        }

        return a;
    }
}
