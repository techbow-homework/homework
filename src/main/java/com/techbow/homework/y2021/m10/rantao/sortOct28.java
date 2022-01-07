package com.techbow.homework.y2021.m10.rantao;

public class sortOct28 {
    public int findKthLargestOct28(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<=0) return -1;

        return quickSelection(nums, 0, nums.length-1, nums.length-k);

    }
    //Use quick selection to find partition
    private int quickSelection(int[] nums, int begin, int end, int k){

        if(begin > end) return Integer.MAX_VALUE;

        int pivot = nums[end];
        int  index = begin;

        for( int i = begin; i< end; i++){
            if( nums[i] <= pivot) {
                swap(nums, index, i);
                index ++;
            }
        }

        swap( nums, index, end);
        // quick select recursively until index = k
        if(index == k) return nums[index];
        else if (index < k) return quickSelection(nums, index + 1, end, k);
        else return quickSelection( nums, 0, index - 1, k);
    }

    private void swap( int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
