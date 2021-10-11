package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;

public class LC237DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        ListNode prev = node;
        while(node.next !=null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return;
    }
}
