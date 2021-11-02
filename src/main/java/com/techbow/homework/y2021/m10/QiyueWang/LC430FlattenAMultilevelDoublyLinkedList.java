package com.techbow.homework.y2021.m10.QiyueWang;

public class LC430FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        //if(head == null) return head;
        Node cur = head;
        Node prev = head;
        while(cur != null){
            Node next = cur.next;
            if(cur.child != null){
                Node[] temp = dfs(cur.child);
                cur.child = null;
                cur.next = temp[0];
                temp[0].prev = cur;
                if(next != null){
                    temp[1].next = next;
                    next.prev = temp[1];
                }

            }
            prev = cur;
            cur = next;
        }
        return head;
    }
    private Node[] dfs(Node head){
        Node cur = head;
        Node prev = head;
        while(cur != null){
            Node next = cur.next;
            if(cur.child != null){
                Node[] temp = dfs(cur.child);
                cur.child = null;// set to null
                cur.next = temp[0];
                temp[0].prev = cur;
                if(next != null){// in case of child at the end
                    temp[1].next = next;
                    next.prev = temp[1];
                }else{ //return the next tail
                    cur = temp[1];
                }

            }
            prev = cur;
            cur = next;
        }
        return new Node[]{head, prev};
    }
}
