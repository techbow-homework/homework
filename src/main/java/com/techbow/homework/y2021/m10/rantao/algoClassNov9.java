package com.techbow.homework.y2021.m10.rantao;

public class algoClassNov9 {
  class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }}

    public ListNode mergeTwo (ListNode a, ListNode b) {

        if(a == null) return b;
        if(b == null) return a;

        ListNode head, cur;
        if(a.val < b.val) {
            head = a;
            a = a.next;
        }else {
            head = b;
            b= b.next;
        }
        cur = head;
    while( a != null && b != null) {
        if(a.val < b.val) {
            cur.next = a;
            a = a.next;
        }else {
            cur.next = b;
            b = b.next;
        }
        cur = cur.next;
    }
	if(a != null) cur.next = a;
	if(b != null) cur.next = b;
	return head;
}

}
