package com.techbow.homework.y2021.m10.rantao;

public class linkedListnov17 {
    public ListNode sortList(ListNode head) {
        if( head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null) {
            if(list1.val <list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1: list2;
        return dummyHead.next;

    }
    public ListNode getMid(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid;
        // adding the case for when there's two nodes in the list;
        if(head.next.next == null) {
            mid = head.next;
            head.next = null;
            return mid;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow.next;
        slow.next = null;

        return mid;
    }

}
