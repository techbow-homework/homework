package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1. 1 <= k <= nums.length <= 10^4
2. -10^4 <= nums[i] <= 10^4
 */
public class LC_0215 {
    // S1: sort and return kth element
    // time: O(nlogn); space: O(1)
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums); // Collections.sort() can sort array, linkedlist, queue and etc.
//        return nums[nums.length - k];
//    }

    // S2: minHeap k size
    // time: add n elements into k size minHeap O(nlogk); space: O(k)
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int n : nums) {
//            minHeap.add(n);
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//        return minHeap.poll();
//    }

    // S3: maxHeap n size
    // time: add n elements in n size maxHeap O(nlogn) + pop k times O(k); space: O(n)
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
//        for (int n : nums) {
//            maxHeap.add(n);
//        }
//        while (k > 1) {
//            maxHeap.poll();
//            k--;
//        }
//        return maxHeap.poll();
//    }

    // S4: quick selection
    // time: best case O(n) worst case o(n^2); space: O(1)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];

        // choose random pivot for partition
        Random randomIndex = new Random();
        int pivotIndex = start + randomIndex.nextInt(end - start); // random.nextInt(n) --> [0, n)
        int pivotValue = nums[pivotIndex];
        // move pivotIndex to the end for swap
        swap(nums, pivotIndex, end);
        int curr = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, curr++, i);
            }
        }
        // last state out of for loop, nums[curr] must be greater or equal to nums[i]
        // so one more swap
        swap(nums, curr, end);

        if (curr == k) return nums[curr];
        else if (curr < k) return quickSelect(nums, curr + 1, end, k);
        else return quickSelect(nums, start, curr - 1, k);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
