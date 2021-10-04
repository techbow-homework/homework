package com.techbow.homework.y2021.m10.kuixiaosu;

public class LC_215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }
}
