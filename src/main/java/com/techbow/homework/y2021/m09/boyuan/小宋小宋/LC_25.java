package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
                count--;
            }
            head = curr;
        }
        return head;
    }
}
