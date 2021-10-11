package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy, cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;

        }
        return dummy.next;
    }

    public static ListNode removeElements_r(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements_r(head.next,val);
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(6);
        ListNode n4= new ListNode(3);
        ListNode n5= new ListNode(4);
        ListNode n6= new ListNode(5);
        ListNode n7= new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        removeElements_r(n1,6);

//        ListNode n1= new ListNode(7);
//        ListNode n2= new ListNode(7);
//        ListNode n3= new ListNode(7);
//        ListNode n4= new ListNode(7);
//        ListNode n5= new ListNode(7);
//        ListNode n6= new ListNode(7);
//        ListNode n7= new ListNode(7);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        removeElements(n1,6);
    }

}
