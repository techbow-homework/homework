package com.techbow.homework.y2021.m10.mengyu;

public class LC160IntersectionOfTwoLinkedLists {
        /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //two hashmaps
        Map<ListNode, Integer> checkIntersection = new HashMap<>();
        //Map<ListNode, Integer> headBMap = new HashMap<>();
        while (headA != null) {
            checkIntersection.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (checkIntersection.containsKey(headB)) {
                return headB;
            }

            headB = headB.next;
        }
        return null;
    }
    */

    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        //math
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (pointerA != null) {
            pointerA = pointerA.next;
            lengthA++;
        }
        while (pointerB != null) {
            pointerB = pointerB.next;
            lengthB++;
        }
        pointerA = headA;
        pointerB = headB;
        while (pointerA != pointerB) {
            if (lengthA == lengthB) {
                pointerA = pointerA.next;
                pointerB = pointerB.next;
            } else if (lengthA > lengthB) {
                pointerA = pointerA.next;
                lengthA--;
            } else {
                pointerB = pointerB.next;
                lengthB--;
            }
        }
        return pointerA;

    }
}
