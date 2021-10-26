package com.techbow.homework.y2021.m10.rantao;

public class sortOct24 {
    // Sort Color/ Dutch flag problem, two pass , O(m+n) space
    public void sortColors(int[] nums) {
        int c0 = 0 , c1 = 0 , c2 = 0 ;

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0) {
                c0 += 1;
            }else if (nums[i] == 1) {
                c1 += 1;
            }else {
                c2 += 1;
            }
        }
        for ( int j = 0; j < c0; j++) {
            nums[j] = 0;
        }
        for ( int k = c0 ; k < c0 + c1; k++) {
            nums[k] = 1;
        }
        for ( int l = c0+c1 ; l < c0 + c1 + c2; l++) {
            nums[l] = 2;
        }
    }
    // one pass, three pointer, swap
    public void sortColors2(int[] nums) {
        //corner case
        if(nums == null || nums.length ==0) return;

        int p0 = 0, p2 = nums.length-1;

        for(int i = 0; i <= p2; i++) {
            if(nums[i] == 0) {
                swap( nums, p0, i);
                p0++; // p0 and i will point to the same index on next round
            }
            else if(nums[i] == 2) {
                swap( nums, p2 , i);
                p2--; //move p2 index to the left
                i--; // p0 is unchanged, so i-- and i++ will cancel out
            }
            // if nums[i] == 1, then no swap, index i moves forward

        }}
    private void swap ( int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
