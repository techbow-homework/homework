package com.techbow.homework.y2021.m10.diJieShuiBuXing.算法冲刺.二分猜值;

public class LC215 {
    public static int findKthLargest(int[] nums, int k) {
        if( nums == null || nums.length == 0 || k <=0){
            throw new IllegalArgumentException("invalid input");
        }

        int l = -10000, r = 10000;

        while( l <= r){
            int mid = r - ( r - l) / 2;
            if( helper( nums, mid)<k ){
                r = mid -1;
            }else{
                l = mid+1;
            }
        }

        return r;
    }



    private static int helper(int[] nums, int t){
        int count = 0;
        for(int num:nums){
            if(num >= t){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr ={99,99};
        findKthLargest(arr,1);
    }
}
