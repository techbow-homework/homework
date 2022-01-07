package com.techbow.homework.y2021.m10.ryanxu.LC_215.bs;

public class LC_215 {
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = Integer.MIN_VALUE / 2;
        int end = Integer.MAX_VALUE / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (countAmount(nums, mid) >= k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    private int countAmount(int[] nums, int pivot) {

        int res = 0;
        for (int num : nums) {
            if (num >= pivot) {
                res++;
            }
        }

        return res;
    }
}
