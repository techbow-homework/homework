package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC24SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head){

        if( head == null || head.next == null){
            return head;
        }
        // 1->2->3->4
        //问下下个node要返回来的结果,对于1来说 1拿到结果的时候就应该是index为2的地方已经是4->3,所以只需考虑如何把 1->2->4 变为 2，1，4
        ListNode subHead = swapPairs(head.next.next);
        ListNode newHead = head.next;//cache 2,作为新的head，不然就丢了
        head.next.next = head;
        head.next = subHead;

        return newHead;
    }


    public static ListNode swapPairs_1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode subHead = swapPairs_1(head.next.next);
        ListNode newHead = head.next;
        head.next = subHead;
        newHead.next = head;

        return newHead;
    }
}
