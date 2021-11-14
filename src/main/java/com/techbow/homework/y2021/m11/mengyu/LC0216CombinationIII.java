package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LC0216CombinationIII {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult = new ArrayList<>();
        findCombos4(nums, target, 0, 0, result, oneResult);
        int count = result.size();
        return count;
    }
    private void findCombos4(int[] nums, int target, int sum, int layers, List<List<Integer>> result,
                             List<Integer> oneResult) {
        if (sum == target) {
            result.add(new ArrayList<>(oneResult));
            return;
        } else if (sum < target) {
            for (int i = layers; i < nums.length; i++) {
                oneResult.add(nums[i]);
                sum += nums[i];
                findCombos4(nums, target, sum, 0, result, oneResult);
                sum -= oneResult.get(oneResult.size() - 1);
                oneResult.remove(oneResult.size() - 1);
            }
        }
    }
}
