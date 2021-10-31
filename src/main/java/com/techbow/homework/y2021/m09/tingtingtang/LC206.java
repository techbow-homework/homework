public ListNode reverseList(ListNode head) {
        if(head == null){
        return head;
        }
        //create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // reversedList
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode nxt = cur.next;

        while(cur!=null){
        // reverse arrow
        cur.next = pre;
        //update 3 pointer
        pre = cur;
        cur = nxt;
        if(nxt !=null){
        nxt= nxt.next;
        }
        }
        //update head and tail
        head.next = null;
        head = pre;

        return head;

        }
}