package com.techbow.homework.y2021.m10.rantao;

public class algoClassNov2 {

/*
    Q4. Start&Last Position of Target
	-- break question down into smaller parts
    start position
    last position
    option 1: do two binary search, logn + logn = O(logn)
    option 2: find one position, and move the other pointer,  logn + n = O(n)
    pay attention to n

*/

  //  first position:
    public int binarySearch( int[] nums, int target) {
        // corner case
        if (nums.length == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, m = 0;
        while (left + 1 < right) {
            m = left + (right - left) / 2;
            if (nums[m] < target) {
                left = m;
            } else {
                right = m;
            }
        }
        if (nums[left] == target) return left;    //consider edge case 3 3 3 3 4 5 6
        if (nums[right] == target) return right;
// post processing to check if left and right are target
        return -1;
    }
       // last position:
        public int binarySearch( int[] nums, int target) {
            // corner case
            if(nums.length == null || nums.length == 0) return -1;
            int left = 0, right = nums.length-1, m = 0;
            while ( left + 1 < right) {
                m = left + (right - left)/2 ;
                if(nums[m] <= target){
                    left = m;
                }
                else{
                    right = m;
                }
            }

            if(nums[right] == target) return right;    //consider edge case 1 2 3 3 3 3 3 3
            if(nums[left] == target) return left;
// post processing to check if right and left are target
            return -1;

        }}
