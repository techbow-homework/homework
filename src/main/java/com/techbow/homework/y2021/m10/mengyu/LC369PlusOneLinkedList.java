package com.techbow.homework.y2021.m10.mengyu;

public class LC369PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode reverted = revert(head);
        ListNode one = new ListNode(1);
        ListNode revertedResult = addTwoNumbers(reverted, one);
        return revert(revertedResult);
    }
    public ListNode revert(ListNode head) {
        ListNode cur = head;
        ListNode next = null, prev = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode res = new ListNode(0);
        ListNode resCur = res;

        int sum = 0;

        while(temp1 != null || temp2 != null) {
            sum /= 10;

            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }
            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            resCur.next = new ListNode(sum % 10);
            resCur = resCur.next;
        }
        if(sum / 10 == 1) {
            resCur.next = new ListNode(1);
        }

        return res.next;
    }
    /*
     public ListNode plusOne(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        plusOneHelper(dummy);

        if(dummy.val != 0){
            return dummy;
        }

        return head;
    }

    boolean done;
    private void plusOneHelper(ListNode head) {
        if(head == null){
            return;
        }

        plusOneHelper(head.next);

        if(done){
            return;
        }

        if(head.val == 9){
            head.val = 0;
        } else {
            head.val++;
            done = true;
        }
    }
    */
}
