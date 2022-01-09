package com.techbow.homework.y2021.m10.rantao;
import java.util.*;
public class backtrackingDec5 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<> ();
        List<List<Integer>> res = new ArrayList<>();

        backtrack(list,res, 0, candidates, 0, target);
        return res;
    }

    private void backtrack(List<Integer> list, List<List<Integer>> res,int sum, int[] nums, int idx, int target){
        if(sum == target){
            res.add(new ArrayList(list));
        }
        for(int i = idx; i< nums.length; i++ ) {
            if(sum>= target) break;
            sum += nums[i];
            list.add(nums[i]);
            backtrack(list, res,sum, nums, i,target);
            sum -= nums[i];
            list.remove(list.size() -1 );
        }

    }
}
