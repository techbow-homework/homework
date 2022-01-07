package com.techbow.homework.y2021.m10.ryanxu.LC_382.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC_382 {

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }
    private List<Integer> list;
    private Random random;
    public LC_382(ListNode head) {

        this.list = new ArrayList<>();
        this.random = new Random();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
    }

    public int getRandom() {

        return this.list.get(this.random.nextInt(this.list.size()));
    }
}
