package com.techbow.homework.y2021.m10.zekun;

public class LC0206_reverse_LinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
//链表操作：先用一个新node prev作为tail node，然后用cur node指向head开始处理链表；
//当cur不为null（即cur还没走到原来链表的尾巴）不跳出loop；
//用next 指针指向cur的下一个node，接下来翻转链表的指向，cur.next重新指向prev，
//然后把prev和cur都往下挪一个位置：把cur赋给prev，然后next赋给cur；

