package com.techbow.homework.y2021.m10.mengyu;

public class LC86PartitionList {
    public ListNode partition(ListNode head, int x) {
        /*
        1 4 3 2 5 2
                    c

     ds 1 2 2
            c
     db 4 3 5
            c
        */
        //corner case
        if (head == null) return null;
        ListNode dummySmaller = new ListNode(0);
        ListNode dummyBigger = new ListNode(0);
        ListNode cur = head;
        ListNode dummyScur = dummySmaller;
        ListNode dummyBcur = dummyBigger;

        while (cur != null) {
            if (cur.val < x) {
                dummyScur.next = new ListNode(cur.val);
                dummyScur = dummyScur.next;
            } else {
                dummyBcur.next = new ListNode(cur.val);
                dummyBcur = dummyBcur.next;
            }
            cur = cur.next;
        }
        dummyScur.next = dummyBigger.next;
        return dummySmaller.next;
    }
}
