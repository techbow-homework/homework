package com.techbow.homework.y2021.m10.rantao;

public class algoClassNov1 {
   // 算法陪练 11.1

    //S1.
    public int binarySearch(int[] nums, int target) {
        // corner case
        if(nums.length == null || nums.length == 0) return -1;
        //check  == null first, or else there’d be non-pointer exception
        int left = 0, right = nums.length -1, m = 0;
        while ( left <= right) {
            m = left + (right - left)/2; // to prevent integer overflow
            if(nums[m] == target) return m;
            if(nums[m] < target) {
                left = m +1;
            }
            else {
                right = m -1;
            }
            return -1;
        }
    }
   // time complexity: O(log(n)) every loop, size of problem reduce by half, inside loop, O(1)
   // space complexity: O(1)

   // S3.
    public int binarySearch(int[] nums, int target) {
    // corner case
        if(nums.length == null || nums.length == 0) return -1;
        int left = 0, right = nums.length-1, m = 0;
        while ( left + 1 < right) {
            m = left + (right - left)/2 ;
            if( nums[m] == target) return m;

            if(nums[m] < target){
                left = m;
            }
            else{
                right = m;
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
// post processing to check if left and right are target
        return -1;
    }

}
