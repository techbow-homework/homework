package com.techbow.homework.y2021.m09.tingtingtang;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

public class LinkedListImpl {
    Node head;
    int size;

    public LinkedListImpl() {
        this.head = new Node(-1, null); // dummy node
        this.size = 0;
    }

    public void add(int index, int val) {
        if (index > size) {
            System.out.println("Illegal index.");
            return;
        }

        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node later = pre.next;

        // real insert
        Node newNode = new Node(val);
        pre.next = newNode;
        newNode.next = later;

        size++;
    }

    public void prettyPrint() {
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d -> ", cur.val);
            cur = cur.next;
        }

        System.out.printf("\n Linked list size: %d.", size);
    }

    public static void main(String[] args) {
            LinkedListImpl linkedList = new LinkedListImpl();

            System.out.println("Expect empty linkedlist.");
            linkedList.prettyPrint();

            linkedList.add(0, 1);
            linkedList.add(1, 3);
            System.out.println("Expect linkedlist: 1 -> 3");
            linkedList.prettyPrint();

            linkedList.add(10, 0);

            linkedList.add(1, 2);
            System.out.println("Expect linkedlist: 1 -> 2 -> 3");
            linkedList.prettyPrint();
;
    }
}


