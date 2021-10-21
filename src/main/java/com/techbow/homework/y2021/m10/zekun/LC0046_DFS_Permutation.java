package com.techbow.homework.y2021.m10.zekun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0046_DFS_Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //cc
        if(nums == null || nums.length == 0) return res;

        dfs(nums, res, 0);

        return res;


    }

    private void dfs(int[] nums, List<List<Integer>> res, int index){
        int numLen = nums.length;
        if(index == numLen - 1){
            List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(tmp);
        }

        for(int i = index; i < numLen; i++){
            swap(nums, index, i);
            dfs(nums, res, index + 1);
            swap(nums, index, i);
        }

    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
