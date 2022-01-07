package com.techbow.homework.y2021.m10.rantao;
import java.util.*;
public class dfsDec4 {
    // subset with duplicate values;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;

    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }
}
