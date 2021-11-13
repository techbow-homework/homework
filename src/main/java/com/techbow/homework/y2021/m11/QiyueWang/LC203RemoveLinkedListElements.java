package com.techbow.homework.y2021.m11.QiyueWang;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LC203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //if(head == null || head.val == val && head.next == null) return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur.next = null;
                cur = prev.next;
            }else{
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
