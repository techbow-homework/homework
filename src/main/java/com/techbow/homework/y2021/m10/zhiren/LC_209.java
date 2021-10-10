package com.techbow.homework.y2021.m10.zhiren;

public class LC_209 {
    public int minSubArrayLen(int target, int[] nums) {
        //cc
        if (nums.length == 0 || nums == null) return 0;

        int n = nums.length;

        int i = 0, sum = 0, res = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++){
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res,j-i+1);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args){
        LC_209 lc = new LC_209();
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};


        System.out.println(lc.minSubArrayLen(target,nums));

        

    }
}
