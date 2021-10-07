package com.techbow.homework.y2021.m09.QiyueWang;
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LC725SplitLinkedListInPairs {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        if(head == null ) return res;
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count ++;
        }
        int num = count / k;
        int mod = count % k;

        cur = head;
        for(int i = 0; i < k; i++){
            int curNum = 0;
            ListNode newHead = cur;
            if(i < mod){
                while(curNum < num){
                    cur = cur.next;
                    curNum ++;
                }
            }else{
                while(curNum < num - 1){
                    cur = cur.next;
                    curNum ++;
                }
            }
            if(cur != null){
                ListNode tail = cur;
                cur = cur.next;
                tail.next = null;
            }
            res[i] = newHead;
        }

        return res;
    }


}
