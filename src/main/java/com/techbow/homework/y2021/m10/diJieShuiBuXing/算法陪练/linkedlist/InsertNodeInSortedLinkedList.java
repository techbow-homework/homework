package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

//没有使用dummy node 但是使用preprocessing提前剔除了
//insertNode_1 只用了一个node，将cur用prev.next替换了
public class InsertNodeInSortedLinkedList {
    public static ListNode insertNode(ListNode head, int value){
        ListNode newNode = new ListNode(value);
        if(head == null || head.val>value){ // preprocessing
            newNode.next = head;
            return newNode;
        }

        ListNode prev = null, cur = head;

        while(cur !=null && cur.val< value){
            prev = cur;
            cur = cur.next;
        }

        newNode.next = cur;
        prev.next = newNode;
        return head;
    }
    public static ListNode insertNode_1(ListNode head, int value){
        ListNode newNode = new ListNode(value);
        if(head == null || head.val>value){ // preprocessing
            newNode.next = head;
            return newNode;
        }

        ListNode prev = null;
        prev.next =head;

        while(prev.next !=null && prev.next.val< value){
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2= new ListNode(2);
        ListNode n3= new ListNode(3);
        ListNode n4= new ListNode(5);
        ListNode n5= new ListNode(6);
        n1.next = n2;
        n2.next = n3;n3.next = n4;
        n4.next = n5;
        insertNode(n1,4);
    }
}
