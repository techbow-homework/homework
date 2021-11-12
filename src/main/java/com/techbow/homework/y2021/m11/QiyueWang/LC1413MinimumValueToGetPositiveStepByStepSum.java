package com.techbow.homework.y2021.m11.QiyueWang;

public class LC1413MinimumValueToGetPositiveStepByStepSum {
    public static int minStartValue(int[] nums) {
        int min = 100;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = Math.min(min, sum);
        }
        return min > 0 ? 1 : 0 - min + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-3,2,-3,4,2};
        int[] nums2 = new int[]{1,2};
        int[] nums3 = new int[]{1,-2,-3};
        System.out.println(minStartValue(nums1));//5
        System.out.println(minStartValue(nums2));//1
        System.out.println(minStartValue(nums3));//5
    }
}
//time O(n) space O(1)
