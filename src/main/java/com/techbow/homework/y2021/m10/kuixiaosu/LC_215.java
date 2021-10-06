<<<<<<< HEAD
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
=======
package com.techbow.homework.y2021.m10.kuixiaosu;

import java.util.PriorityQueue;

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
>>>>>>> a1e7104c76f408e735a7c87017ab95e8de29924f
