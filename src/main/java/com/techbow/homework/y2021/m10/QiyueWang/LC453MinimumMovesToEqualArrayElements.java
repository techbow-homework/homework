package com.techbow.homework.y2021.m10.QiyueWang;

public class LC453MinimumMovesToEqualArrayElements {
    // increment n-1 by one equals decrement the max by one in this case, ans = sum(nums[i] - min) = sum - min * n
    // or ans = (m * n - sum) / (n - 1)  ==>  with m = min + ans ==> ans = sum - min * n
    public static int minMoves(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int res = 0;
        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            res += nums[i];
        }
        return res - n * min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(minMoves(nums)); // 3
        int[] nums2 = new int[]{3,4,6,6,3};
        System.out.println(minMoves(nums2));// 7
    }
}
// time O(N) space O(1)