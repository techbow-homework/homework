package com.techbow.homework.y2021.m10.kuixiaosu;

public class ReverseLinkedListByPair {
    public ListNode reverseListByPair(ListNode head){
        // corner case
        if (head == null || head.next == null) return head;
        ListNode subHead = reverseListByPair(head.next.next); //在4要被丢失前存一下
        head.next.next = head; // 2 → 1
        ListNode newHead = head.next; //在2要被丢失前存一下
        head.next = subHead; // 1 → 4
        return newHead;
    }
}
