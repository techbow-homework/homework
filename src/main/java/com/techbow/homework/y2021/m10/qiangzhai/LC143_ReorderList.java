package com.techbow.homework.y2021.m10.qiangzhai;

public class LC143_ReorderList {
    public void reorderList(ListNode head) {
        //cc
        if (head == null || head.next == null) return;
        //find mid
        ListNode mid = getMid(head);
        //two linkedlist
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        //cut off the connection; split the list
        mid.next = null;//预防性编程：奇偶情况，奇数会有环如果不断开！
        //merge two linkedlist
        ListNode result = mergeList(leftHead, reverseList(rightHead));
    }

    private ListNode getMid(ListNode head) {
        //cc
        if (head == null || head.next == null) return head;//与下面的check fast不能重复！
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {//如果fast = head, 就需要check fast.next.next
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        //cc
        if (head == null || head.next == null) return head;
        //
        ListNode prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //while loop to pair merge
    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode l1 = head1, l2 = head2;
        while (l1 != null && l2 != null) {//这里也说明需要挂null，变成两个linkedlist
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        cur.next = l1;//奇数时候，l1比l2多一个listnode！
        return dummy.next;
    }
    //recursion
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode next = l1.next;
        l1.next = l2;
        l2.next = merge(next, l2.next);
        return l1;
    }
}
