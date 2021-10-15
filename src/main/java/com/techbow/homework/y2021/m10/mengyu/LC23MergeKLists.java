package com.techbow.homework.y2021.m10.mengyu;

public class LC23MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        for (int i = 1; i < len; i++) {
            lists[0] = mergeLists(lists[0], lists[i]);
        }
        return lists[0];
    }

    public ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode resultDummy = new ListNode(0);
        ListNode cur = resultDummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                cur.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 == null){
            cur.next = head2;
        } else if (head2 == null) {
            cur.next = head1;
        }
        return resultDummy.next;
    }
}
