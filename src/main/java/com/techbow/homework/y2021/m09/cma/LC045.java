package com.techbow.homework.y2021.m09.cma;

public class LC045 {
    class Solution {
        //     本code assume  “you can always reach the last index.”
        //     DP初始值不能是有意义答案， 用正负无穷时，可以用有效空间内的最大、小值
        //        Greedy

        public int jump(int[] nums) {
            if(nums == null || nums.length < 2) return 0;
            int result = 0;
            int preMax = 0;
            int curMax = 0; // 能到达的最远位置
            for(int i = 0; i < nums.length; i++) { // use curMax to justify whether you can hit the target or not:
                if(i > preMax) {
                    preMax = curMax;
                    result++;
                }
                curMax = Math.max(curMax, i + nums[i]); // i vs cur
                if(curMax >= nums.length - 1) return result + 1;
            }
            return 0; // 跳不到咋办
        }
    }
}
