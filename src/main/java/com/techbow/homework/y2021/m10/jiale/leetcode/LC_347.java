package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Top K Frequent Element
 */
public class LC_347 {
    class Element {
        public int val;
        public int frequency;
        public Element(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // record the frequency O(n)
        Map<Integer, Integer> freqRecord = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqRecord.put(nums[i], freqRecord.getOrDefault(nums[i],0)+1);
        }
        // build a k size minHeap O(nlogk)
        PriorityQueue<Element> minHeap = new PriorityQueue(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.frequency - o2.frequency;
            }
        });
        for (Map.Entry<Integer, Integer> each : freqRecord.entrySet()) {
            if (minHeap.size() >= k) {
                if (each.getValue() > minHeap.peek().frequency) {
                    minHeap.poll();
                } else {
                    continue;
                }
            }
            minHeap.offer(new Element(each.getKey(), each.getValue()));
        }
        // build the result O(klogk)
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = ((Element)minHeap.poll()).val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(new LC_347().topKFrequent(input, 2)));
    }
}
