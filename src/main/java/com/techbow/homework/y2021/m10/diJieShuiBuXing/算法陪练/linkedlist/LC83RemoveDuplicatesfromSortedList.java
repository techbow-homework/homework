package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC83RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;

        while(cur != null&& cur.next != null){
            if( cur.val == cur.next.val){
                ListNode repeatEnd = cur.next;
                while(repeatEnd != null && repeatEnd.val == repeatEnd.next.val){
                    repeatEnd = repeatEnd.next;
                }

                cur.next = repeatEnd.next;
                repeatEnd.next = null;
            }
            cur = cur.next;
        }

        return head;
    }
}
