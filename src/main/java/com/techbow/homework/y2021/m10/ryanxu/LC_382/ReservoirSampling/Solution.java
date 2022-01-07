package com.techbow.homework.y2021.m10.ryanxu.LC_382.ReservoirSampling;

import java.util.Random;

public class Solution {

    private static class ListNode {
        private int val;
        private ListNode next;
        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode node;
    private Random random;
    public Solution(ListNode head) {
        this.node = head;
        this.random = new Random();
    }

    public int getRandom() {

        int res = 0;
        int k = 0; // current num of elements scanned
        ListNode cur = this.node;
        while (cur != null) {
            k++;
            if (random.nextInt(k) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }

        return res;
    }
}
