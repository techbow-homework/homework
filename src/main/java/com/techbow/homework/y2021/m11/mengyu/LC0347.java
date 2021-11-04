package com.techbow.homework.y2021.m11.mengyu;

import java.util.*;

public class LC0347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparing(map::get));
        for (int key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = minHeap.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
