package com.techbow.homework.y2021.m10.ryanxu.LC_215.qs;

public class LC_215 {
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {

        int t = start;
        int i = start;
        int j = end;
        int pivot = nums[start + (end - start) / 2];
        while (t <= j) {
            if (nums[t] < pivot) {
                swap(nums, t, i);
                i++;
                t++;
            } else if (nums[t] > pivot) {
                swap(nums, t, j);
                j--;
            } else {
                t++;
            }
        }

        if (end - j >= k) {
            return quickSelect(nums, j + 1, end, k);
        } else if (end - i + 1 >= k) {
            return pivot;
        } else {
            return quickSelect(nums, start, i - 1, k - (end - i + 1));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC_215 lc_215 = new LC_215();
        int[] nums = {3,2,1,0};
        System.out.println(lc_215.findKthLargest(nums, 2));
    }
}
