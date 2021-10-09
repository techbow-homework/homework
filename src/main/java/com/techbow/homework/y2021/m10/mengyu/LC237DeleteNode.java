package com.techbow.homework.y2021.m10.mengyu;

public class LC237DeleteNode {
    /*
    public void deleteNode(ListNode node) {

        ListNode current = node;
        ListNode next = null;
        while (current.next != null) {
            next = current.next;
            current.val = next.val;
            current = current.next;
        }
        current = node;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
*/
    public void deleteNode(ListNode node) {
        ListNode holding = node.next;
        node.next = holding.next;
        node.val = holding.val;
    }
}
