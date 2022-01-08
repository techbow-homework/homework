package com.techbow.homework.y2021.m10.yeboyr;

public class leet328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if(head == null) return null;
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenhead = even;

            while(even != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }

            odd.next = evenhead;
            return head;
        }
    }
}
