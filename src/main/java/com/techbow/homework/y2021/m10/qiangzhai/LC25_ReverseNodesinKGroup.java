package com.techbow.homework.y2021.m10.qiangzhai;

public class LC25_ReverseNodesinKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //base case
        if (head == null || getLen(head) < k) return head;
        //reverse K size linked list
        ListNode prev = null, cur = head, next = null;
        int cnt = 0;
        while (cur != null && cnt < k) {// from node 1 to node k
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            cnt++;
        }
        //recursion
        head.next = reverseKGroup(cur, k);// cur @ (k + 1)th node
        return prev;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
