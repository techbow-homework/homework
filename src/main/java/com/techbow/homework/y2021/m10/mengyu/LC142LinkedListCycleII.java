package com.techbow.homework.y2021.m10.mengyu;

public class LC142LinkedListCycleII {
    /*
   public ListNode detectCycle(ListNode head) {
       //hashsmap
       Map<ListNode, Integer> detectNode = new HashMap<>();
       while (head != null) {
           if (detectNode.containsKey(head)) {
               return head;
           }
           detectNode.put(head, 1);
           head = head.next;
       }
       return null;
   }
   */
    public ListNode getIntersect(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return slowPointer;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        //TODO: corner cases
        ListNode intersection = getIntersect(head);
        if (intersection == null) return null;

        ListNode pointer1 = head;
        ListNode pointer2 = intersection;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
