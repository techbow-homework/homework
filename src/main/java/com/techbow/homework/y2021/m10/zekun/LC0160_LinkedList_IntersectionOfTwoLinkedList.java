package com.techbow.homework.y2021.m10.zekun;

public class LC0160_LinkedList_IntersectionOfTwoLinkedList {
    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        //cc
        if(headA == null || headB == null){
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != pointerB){
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;//没有相交的话，最后pointerA或者pointerB都会走到null，因此返回其中一个就可以；

    }
}
