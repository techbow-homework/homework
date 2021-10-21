package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class returnkthPositionAfterEnterNodeofCycle {
    public ListNode getKth(ListNode head, int k){
        if(head == null){
            return head;
        }
        ListNode s = head, f = head;
        boolean hasCycle = false;

        while(f.next != null && f.next.next != null){
            if(s == f){
                hasCycle = true;
                break;
            }

            s = s.next;
            f = f.next.next;

        }

        if(!hasCycle){
            return null;
        }

        f = head;
        while ( s != f){
            s = s.next;
            f = f.next;
        }

        while(k-- >0){
            s = s.next;
        }
        return s;
    }
}
