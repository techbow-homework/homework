package com.techbow.homework.y2021.m10.qiangzhai;

public class LC136_SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];//a ^ a = 0   a ^ 0 = a looping时，可以理解顺序可变，最后剩的就是single number
        }
        return result;
    }
}
