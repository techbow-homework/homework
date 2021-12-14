package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.List;

public class LC0229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums){
        //投票算法的第一步是确定各个元素多少的相对关系，第二步是确定绝对关系，是否满足答案要求
        //投票算法的work的前提是答案一定有效  所以check frequency就是用来确定这个有效
        List<Integer> res = new ArrayList<Integer>();
        //cc
        if(nums == null || nums.length == 0) return res;
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for(int num : nums){
            if(vote1 > 0 && num == element1){
                vote1++;
            }else if(vote2 > 0 && num == element2){
                vote2++;
            }else if(vote1 == 0){
                element1 = num;
                vote1++;
            }else if(vote2 == 0){
                element2 = num;
                vote2++;
            }else{
                vote1--;
                vote2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length;i++){
            if(vote1 > 0 && nums[i] == element1){
                count1++;
            }
            if(vote2 > 0 && nums[i] == element2){
                count2++;
            }
        }
        if(vote1 > 0 && count1 > nums.length / 3) res.add(element1);//可以是>= 吗？不可以，为什么？考虑[3,2,3]的case
        if(vote2 > 0 && count2 > nums.length / 3) res.add(element2);
        return res;
    }
}
