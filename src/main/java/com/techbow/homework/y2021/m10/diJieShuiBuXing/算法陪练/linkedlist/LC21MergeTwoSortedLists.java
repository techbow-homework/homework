package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ){
            return l2;
        }
        if( l2 == null){
            return l1;
        }

        ListNode head = null, cur = null;

        if(l1.val < l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }

        cur = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }

        if(l2 != null){
            cur.next = l2;
        }
        return head;
    }

    public ListNode mergeTwoLists_recur(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
