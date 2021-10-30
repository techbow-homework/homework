package com.techbow.homework.y2021.m10.rantao;

public class linkedListOct29 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x) {
            val = x;
        }
    }
    private int curSize;

    private ListNode head, tail;

    public LinkedList() {
        this.curSize = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int size() {
        return this.curSize;
    }

    public int get(int index) {
        this.validateIndex(index);
        return this.getIthNode(index).val;
    }
    public void add(int val) {
        this.validateIndex(index);

        ListNode node = this.getIthNode(index);
        ListNode addMe = new ListNode(val);

        this.curSize++;

    }
    public void remove(int index) {
        this.validateIndex(index);
        ListNode node = tis.getIthNode(index);

        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;

        this.curSize--;
    }
    private void validateIndex(int index) {
        if(index<0 || index >=this.curSize) {
            throw new RuntimeException("out of boundary");
        }
    }

    private ListNode getIthNode(int i) {
        ListNode cur = this.head.next;
        while (i-- >0){
            cur = cur.next;
        }
        return cur;
    }
    private void addNodeBehind( ListNode node, ListNode addMe){
        ListNode next = node.next;

        addMe.next = next;
        next.prev = addMe;

        node.next = addMe;
        addMe.prev = node;

    }
    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        while( cur != null) {
            ListNode next = cur.next;
            cur.next = dummy.next;
            dummy.next=cur;
            cur = next;

        }
    }
}
