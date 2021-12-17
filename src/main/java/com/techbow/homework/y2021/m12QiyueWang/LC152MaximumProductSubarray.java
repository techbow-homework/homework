package com.techbow.homework.y2021.m12QiyueWang;

public class LC152MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < n; i++){
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]));
        }
        for(int i = 0; i < n; i++){
            res = Math.max(res, max[i]);
        }
        // System.out.println(Arrays.toString(max));
        // System.out.println(Arrays.toString(min));
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,-2,4};
        int[] nums2 = new int[]{-2,0,-1};
        int[] nums3 = new int[]{-2,3,-4};
        System.out.println(maxProduct(nums1));//6
        System.out.println(maxProduct(nums2));//0
        System.out.println(maxProduct(nums3));//24
    }
}
// time O(n) space O(n)
