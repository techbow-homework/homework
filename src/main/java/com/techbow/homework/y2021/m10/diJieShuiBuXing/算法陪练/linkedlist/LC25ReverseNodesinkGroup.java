package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;


//其实就是 reverse by pair， by3。
// 当时k的时候，其实就是对于k的这个list 做reverse linkedlist， 唯一不同的是，需要把新的head和它的prev连起来
public class LC25ReverseNodesinkGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 0){
            return head;
        }
        ListNode kthNode = head, prev = null;

        for(int i = 0 ; i < k; i++){
            if(kthNode == null){
                return head;
            }
            prev = kthNode;
            kthNode = kthNode.next;
        }


        ListNode subHead = reverseKGroup(kthNode,k);

        ListNode[] newHeadTail = reverseByRange(head,prev); //0 wei newhead. 1 wei new tail
        newHeadTail[1].next = subHead;

        return newHeadTail[0]; //return new head
    }

    private static ListNode[] reverseByRange(ListNode head, ListNode tail) {
        tail.next = null;

        ListNode prev = null, cur = head, next = null;

        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{prev,head};
    }
}
