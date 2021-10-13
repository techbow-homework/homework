package com.techbow.homework.y2021.m10.mengyu;

public class LC148SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    /*
    public ListNode selectionSortList(ListNode head) {

        for(ListNode i = head; i != null; i = i.next) {
            ListNode curr = i;
            ListNode min = curr;
            while (curr != null) {
                if (curr.val < min.val) {
                    min = curr;
                }
            curr = curr.next;
            }
            int temp = min.val;
            min.val = i.val;
            i.val = temp;
        }

        return head;
    }
    */
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public ListNode getMid(ListNode head) {
        /*
        1 2 3 4 5 6
                    h
            m
        */
        ListNode mid = head;
        while (head != null && head.next != null) {
            head = head.next.next;
            if (head == null) {
                break;
            } else {
                mid = mid.next;
            }
        }
        ListNode midNext = mid.next;
        mid.next = null;
        return midNext;
    }
}
