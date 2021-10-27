package com.techbow.homework.y2021.m10.yuewen;

public class ReverseLinkedList {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;

            cur = next;
        }

        return dummy.next;
    }

    public ListNode genList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int val : array) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return dummy.next;
    }

    public void print(ListNode head) {
        StringBuilder sb = new StringBuilder();

        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val + ", ");
            cur = cur.next;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ReverseLinkedList so = new ReverseLinkedList();

        int[] array = {1,2,3,4,5,6,7};
        ListNode head = so.genList(array);

        so.print(head);

        head = so.reverse(head);

        so.print(head);
    }

}
