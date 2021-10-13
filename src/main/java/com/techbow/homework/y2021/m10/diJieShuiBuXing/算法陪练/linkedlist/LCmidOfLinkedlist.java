package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LCmidOfLinkedlist {

    public static ListNode findMiddleNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode s = head, f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        ListNode n5= new ListNode(5);
        ListNode n6= new ListNode(6);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
        findMiddleNode(n1);
    }
}
