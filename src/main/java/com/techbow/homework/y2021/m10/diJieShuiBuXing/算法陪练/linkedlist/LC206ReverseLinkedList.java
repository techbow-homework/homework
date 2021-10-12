package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.linkedlist;



public class LC206ReverseLinkedList {

    /**
     * while iteration写法
     * @param head
     * @return
     */
    public  ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur!=null){//跳出时候 cur == null，所以要return prev
            next = cur.next; //保存next node， 因为要是不保存，直接cur.next = prev 就会丢失next。
            cur.next = prev;//剪头往回指prev
            prev = cur;//赋值prev
            cur = next;//赋值cur
        }
        return prev;
    }

    /**
     * while iteration写法
     * @param head
     * @return
     */
    public  ListNode reverseList_head(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur.next != null){ //如果用cur.next做判断，跳出时候cur是最后一个有效的node，但是他还没有和前年的prev连起来
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;//所以跳出后再连上之前的prev
        return cur;//返回cur
    }



    /**
     * recursion 写法-》先recursion后办事：办事和recursion顺序是相反的
     * @param head
     * @return
     */
    public  ListNode reverseList_recursion_1(ListNode head) {
        //base case, corner case
        if(head == null || head.next == null){
            return head;
        }
        //1
        ListNode newHead = reverseList_recursion_1(head.next);

        //插入后办事儿的34
        head.next.next = head;
        head.next = null;

        //2
        return newHead;
    }

}
