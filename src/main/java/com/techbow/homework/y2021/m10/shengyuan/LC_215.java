/** Kth Largest Element in an Array
 *
 */

package com.techbow.homework.y2021.m10.shengyuan;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_215 {
    public int kLargest(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 < o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                minHeap.offer(array[i]);
            } else if (array[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(array[i]);
            }
        }
        return minHeap.poll();
    }
    public static void main(String[] args) {
        LC_215 test = new LC_215();
        int[] array = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int res = test.kLargest(array, k);
        System.out.println(res);
    }
}
