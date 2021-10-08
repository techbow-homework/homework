package com.techbow.homework.y2021.m10.qiangzhai;

public class LC215_KthLargestElementinArray {
    //using max heap
    public int findKthLargest(int[] nums, int k) {//PriorityQueue default is min heap;
        PriorityQueue<Integer> maxh = new PriorityQueue<>(Collections.reverseOrder());
        //Collections.reverseOrder() change it to max heap;
        for (int n:nums){//assign n = nums' elements
            maxh.add(n);
        }
        while (k > 1){
            maxh.poll();
            k--;
        }
        return maxh.peek();
    }
    //using min heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        for (int i : nums){
            if (minh.size() < k) minh.add(i);
            else{
                if (minh.peek() < i){
                    minh.poll();
                    minh.add(i);
                }
            }
        }
        return minh.peek();
    }
    //clean version
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
