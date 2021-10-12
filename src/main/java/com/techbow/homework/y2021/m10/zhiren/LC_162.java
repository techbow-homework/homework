package com.techbow.homework.y2021.m10.zhiren;


public class LC_162 {
    public static void main(String[] args){
        LC_162 lc = new LC_162();
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int[] nums2 = new int[] {1,2,3,1};
        System.out.println(lc.findPeakElement(nums2));

    }


        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[mid + 1]) left = mid + 1;
                else right = mid;
            }
            return left;
        }

}
