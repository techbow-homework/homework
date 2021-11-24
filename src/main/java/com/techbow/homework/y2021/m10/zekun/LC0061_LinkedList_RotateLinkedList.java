package com.techbow.homework.y2021.m10.zekun;

public class LC0061_LinkedList_RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        //cc
        if(k == 0 || head == null || head.next == null) return head;

        //get size of linked list
        int size = 1;
        ListNode dummy = head;
        while(dummy.next != null){
            dummy = dummy.next;
            size++;
        }

        //find the distance
        int breakPoint = size - k % size;
        if(breakPoint == size) return head;

        dummy.next = head; // form a cycle
        while(breakPoint-- > 0){//dummy starts at the end of the linked list, and dummy goes next untill reach breakPoint comes to 0;
            dummy = dummy.next;
        }

        ListNode ret = dummy.next;
        dummy.next = null;
        return ret;
    }
}
