package com.techbow.homework.y2021.m09.mengyu;

import java.util.ArrayList;

public class MergeSort {
    public void merge(int[] nums, int start, int mid, int end){
        if(start>=end)
            return;
        int leftlen = mid-start+1;
        int rightlen = end-mid;

        int[] left = new int[leftlen];
        int[] right = new int[rightlen];
        int k=start; // for original array

        for(int i=0;i<leftlen;i++){
            left[i] = nums[k];
            k++;
        }

        for(int j=0;j<rightlen;j++){
            right[j] = nums[k];
            k++;
        }

        int i=0,j=0;
        k=start;
        while(i<leftlen && j<rightlen){
            if(left[i]<=right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }

            else {
                nums[k] = right[j];
                j++;
                k++;
            }
        }

        while(i<leftlen){
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j<rightlen){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public void mergesort(int[] nums, int start, int end){
        if(start>=end)
            return;

        int mid = (end+start)/2;
        mergesort(nums, start, mid);
        mergesort(nums, mid+1,end);

        merge(nums, start, mid, end);
    }

    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);

        return nums;
    }
}
