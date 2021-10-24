package com.techbow.homework.y2021.m10.QiyueWang;

public class LC154FindMinimumInRotatedSortedArrayII {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -5001;
        int n = nums.length;
        if(n == 1) return nums[0];

        int l = 0;
        int r = n - 1;
        while (l <= r){
            int mid = l + (r - l)/2;

            if(nums[r] < nums[mid]){
                l = mid + 1;
            }else if(nums[r] > nums[mid]){
                r = mid;
            }else{
                r--;
            }
            //System.out.println(nums[mid]);
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,5,6,7,1,1,4};
        int[] nums2 = new int[]{2,2,2,0,1};
        System.out.println(findMin(nums1)); // 1
        System.out.println(findMin(nums2)); // 0
    }
}
//time O(N) worst case, space O(1)
