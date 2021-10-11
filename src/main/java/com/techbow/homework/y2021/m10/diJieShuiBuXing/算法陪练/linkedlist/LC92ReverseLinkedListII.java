package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;



public class LC92ReverseLinkedListII {
    //range是一个左开右闭的区间，不然找不到range的左右两个起始点
    public  ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null|| left>=right){
            return head;
        }

        ListNode prev = null, cur = head , next = null;
        while(left-- >1){
            if(cur == null){
                return head;
            }
            prev = cur;
            cur = cur.next;
            right--;
        }

        ListNode preHead = prev, tail = cur;

        while(right--> 0){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        if(preHead != null){
            preHead.next = prev;
        }else{
            head = prev;
        }

        tail.next = cur;
        return head;
    }

}
