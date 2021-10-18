package com.techbow.homework.y2021.m10.zekun;

import java.util.Arrays;

public class LC0259_TwoPointers_ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        //cc
        if(nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int curTar = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] >= curTar){
                    end--;
                }else{
                    count += end - start;
                    start++;
                }
            }
        }
        return count;

    }
}
//思路是3 sum的思路，先固定住一个i，然后 变成了2 sum解法，双指针相向而行；
// 不同的是这里是小于target的所有combination，那么left 和 right
// 加起来等于target的时候，要做end--，而和小于target的时候，
// start+1 和 end 之间的所有值，都是一定和小于target的，
// 因此返回的combination 数量是end - start；
// 和大于target的时候，什么都判断不出，所以只能end--，因此与等于target合并写了；