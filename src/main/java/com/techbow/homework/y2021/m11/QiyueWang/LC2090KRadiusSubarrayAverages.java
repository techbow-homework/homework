package com.techbow.homework.y2021.m11.QiyueWang;

import java.util.Arrays;

public class LC2090KRadiusSubarrayAverages {
    public static int[] getAverages(int[] nums, int k) {
        if(k == 0) return nums;
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        int[] res = new int[n];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for(int i = 0; i < n; i++){
            if(i - k < 0 || i + k >= n){
                res[i] = -1;
            }else if(i - k == 0){
                res[i] = (int)((prefix[i + k]) / (2 * k + 1));
            }else{
                res[i] = (int)((prefix[i + k] - prefix[i - k - 1]) / (2 * k + 1));
            }
        }
        //System.out.println(Arrays.toString(prefix));
        //System.out.println(prefix[n - 1]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        System.out.println(Arrays.toString(getAverages(nums, 3)));//[-1,-1,-1,5,4,4,-1,-1,-1]
    }
}
