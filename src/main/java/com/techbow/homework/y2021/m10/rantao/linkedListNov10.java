package com.techbow.homework.y2021.m10.rantao;

public class linkedListNov10 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // making slow n nodes from fast
        while(n > 0){
            fast = fast.next;
            n--;
        }
        if(fast == null) {
            head = head.next;
            return head;
        }
        // slow should be nth + 1 node from the end of the list
        // in order to delete a node we would need to know the node before that node, so when fast.next != null, fast is the last node.
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //delete the node
        slow.next = slow.next.next;

        return head;
    }
}
