package com.techbow.homework.y2021.m10.mengyu;

import java.util.HashMap;
import java.util.Map;

public class LC141linkedListCycle {
    /*
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> checkNodes = new HashMap<>();
        while (head != null) {
            if (checkNodes.containsKey(head)) {
                return true;
            }
            checkNodes.put(head,1);
            head = head.next;
        }
        return false;
    }
    */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
