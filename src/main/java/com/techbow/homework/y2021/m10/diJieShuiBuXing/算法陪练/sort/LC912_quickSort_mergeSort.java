package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法陪练.sort;



/**
 * Given an nums of integers nums, sort the nums in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class LC912_quickSort_mergeSort {
    // merge sort
    public static int[] mergeSortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("invalid input");
        }

        mergeSort(nums, 0 , nums.length-1);
        return nums;
    }

    private static void mergeSort(int[] nums, int start , int end) {

        if(start >= end){
            return ;
        }

        int mid = start + (end - start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);

        // merge to int[] temp

        int i = start, j = mid+1, p = 0;//i 为前半段的起点，j为后半段的起点，p为temp的index
        int[] temp = new int[ end - start + 1];
        while(i <= mid && j <=end){
            // temp[p++] =  nums[i] > nums[j]? nums[i++]:nums[j++];
            if(nums[i]< nums[j]){
                temp[p++] = nums[i++];
            }else{
                temp[p++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[p++] = nums[i++];
        }

        while(j <= end){
            temp[p++] = nums[j++];
        }

        for(int k = 0; k < temp.length; k++){
            nums[k+start] = temp[k];
        }
    }


    public static int[] quickSortArray(int[] nums) {
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("invalid input");
        }

        quickSort(nums, 0 , nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {
        if(start >= end){
            return;
        }

        int pv = nums[start + ( end- start )/2];

        int s = start, e = end;
        while( s <= e){
            while( s <=e && nums[s] < pv){
                s++;
            }

            while( s<=e && nums[e] > pv){
                e--;
            }

            if(s <= e){
                swap(nums,s++,e--); // key point!!!
            }
        }
        quickSort(nums,start,e);
        quickSort(nums,s,end);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public int[] qs(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }

        qsHelper(nums,0,nums.length-1);
        return nums;
    }

    private void qsHelper(int[] nums, int start, int end) {
        if(start>=end){
            return;
        }

        int pv = nums[start +(end-start)/2];

        int s = start, e = end;
        while(s <= e){
            while(s <= e && nums[s]< pv){
                s++;
            }
            while (s <= e && nums[e]>pv){
                e--;
            }
            if(s <=e){
                swap(nums,s++,e--);
            }
        }

        qsHelper(nums,start,e);
        qsHelper(nums,s,end);
    }


}
