package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_34 {
    public int[] searchRange(int[] nums, int target) {
        //corner case
        if (nums == null || nums.length == 0) return new int[] {-1,-1};
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    private int findFirst(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid;
            else right = mid;
        }
        if (nums[left] == target) index = left;
        else if (nums[right] == target) index = right;
        return index;
    }
    private int findLast(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid;
            else left = mid;
        }
        if (nums[right] == target) index = right;
        else if (nums[left] == target) index = left;
        return index;
    }
}
