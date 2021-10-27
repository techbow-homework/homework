package com.techbow.homework.y2021.m10.mengyu;

public class Q4InsertValueIntoSortedLinkedList {
    public static ListNode Q4InsertValueIntoSortedLinkedList (ListNode head, int val) {
        //no dummy node
        /*
        val = 4.5
        1 2 3 4 5
              c
         */
        ListNode newHead = new ListNode(val);
        if (head == null || head.val > val) {
            newHead.next = head;
            return newHead;
        }
        ListNode curr = head;
        while (curr.next != null && curr.next.val < val) {
            curr = curr.next;
        }
        newHead.next = curr.next;
        curr.next = newHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        int target = 0;

        System.out.println(Q4InsertValueIntoSortedLinkedList(head, target));
    }
}
