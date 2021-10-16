package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC147InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null, cur = head, temp = null, dummy = new ListNode(), next = null;
        dummy.next = head;

        while(cur != null && cur.next != null){
            if( cur.val <= cur.next.val){
                cur = cur.next;
            }else{
                temp = cur.next;
                cur.next = cur.next.next;
                prev = dummy;
                while(prev !=null && prev.next.val <= temp.val){
                    prev = prev.next;
                }

                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode n1= new ListNode(-1);
        ListNode n2= new ListNode(5);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(4);
        ListNode n5= new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
    }
}
