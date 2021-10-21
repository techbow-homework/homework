package com.techbow.homework.y2021.m10.zhiren;

import java.util.List;

public class LC_86 {
    public ListNode partition_list(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        // dummy node
        ListNode small = new ListNode(Integer.MIN_VALUE);
        ListNode big = new ListNode(Integer.MIN_VALUE);
        ListNode smallHead = small;
        ListNode bigHead = big;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        // avoid cycle
        big.next = null;
        small.next = bigHead.next;
        bigHead.next = null;
        return smallHead.next;
    }



  public static void main(String args[]){
      LC_86 lc = new LC_86();

      int x = 3;
      //1,4,3,2,5,2
      ListNode head = new ListNode(1);
      head.next = new ListNode(4);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(2);
      head.next.next.next.next = new ListNode(5);
      head.next.next.next.next.next = new ListNode(2);
      ListNode temp = lc.partition_list(head,x);
      while (temp != null){
          System.out.println(temp.val);
          temp = temp.next;
      }


  }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}