package com.techbow.homework.y2021.m10.rantao;
public class searchRange {
    public int[] searchRange1(int[] nums, int target) {
        int res[] = { -1, -1 };
        if (nums.length == 0)
            return res;
        int left = binarySearch(nums, target - 0.5);
        int right = binarySearch(nums, target + 0.5);
        if (right - left == 0)
            return res;
        res[0] = left;
        res[1] = right - 1;
        return res;
    }
    private int binarySearch(int[] arr, double target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target)
                right = mid - 1;
            else if(arr[mid] < target)
                left = mid + 1;
        }
        return left;
}
}
