package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC160IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }


        ListNode a = headA, b = headB;

        while( a != b){
            if(a == null){
                a = headB;
            }else{
                a = a.next;
            }

            if(b == null){
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
}
