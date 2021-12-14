package com.techbow.homework.y2021.m10.zekun;

public class LC0238_ProductExceptItself {
    /*
    原数组：       [1       2       3       4]
    左部分的乘积：   1       1      1*2    1*2*3
    右部分的乘积： 2*3*4    3*4      4      1
    结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
    */
    public int[] productExceptSelf(int[] nums) {
        //cc
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length];
        int len = nums.length;
        int left = 1;
        res[0] = left;
        for(int i = 1; i < len; i++){
            left = left * nums[i - 1];
            res[i] = left; //first pass assign each left to res[i]
        }
        int right = 1;
        for(int i = len - 1; i >= 0 ; i--){
            if(i < len - 1){
                right = right * nums[i + 1];
            }
            res[i] *= right; //second pass assign each right * left to res[i]
        }
        return res;
    }
}
