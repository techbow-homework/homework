package com.techbow.homework.y2021.m10.mengyu;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC215 {
    public int KthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(k,Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }
        int res = maxHeap.poll();
        while (--k > 0) {
            res = maxHeap.poll();
        }
        return res;
    }
}
