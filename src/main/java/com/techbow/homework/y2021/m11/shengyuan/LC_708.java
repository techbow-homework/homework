package com.techbow.homework.y2021.m11.shengyuan;

class ListNode {
    public int value;
    public ListNode next = null;

    public ListNode() {

    }
    public ListNode(int value) {
        this.value = value;
    }
    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

public class LC_708 {
    public ListNode insert(ListNode head, int insertValue) {
        if (head == null) {
            head = new ListNode(insertValue);
            head.next = head;
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != head) {
            if ((insertValue >= prev.value && insertValue <= cur.value) || (prev.value > cur.value && (insertValue >= prev.value || insertValue <= cur.value))) {
                ListNode insertNode = new ListNode(insertValue);
                insertNode.next = cur;
                prev.next = insertNode;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if (cur == head) {
            ListNode insertNode = new ListNode(insertValue);
            insertNode.next = cur;
            prev.next = insertNode;
        }
        return head;
    }

    public static void main(String[] args) {
        LC_708 test = new LC_708();
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = null;
        int insertValue = 5;
        test.insert(head, insertValue);
        ListNode cur = head;
        while (cur != head) {
            System.out.print(cur.value);
            cur = cur.next;
        }
    }
}
