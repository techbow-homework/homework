package com.techbow.homework.y2021.m11.mengyu;

import java.util.*;

public class LC47PermutationsWithDup {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        //List<Integer> oneResult = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        findPermutations(numsList, resultSet, 0);
        List<List<Integer>> result = new ArrayList<>(resultSet);
        return result;
    }
    private void findPermutations (List<Integer> numsList, Set<List<Integer>> resultSet, int level) {
        if (level == numsList.size()) {
            resultSet.add(new ArrayList<>(numsList));
            return;
        }
        for (int i = level; i < numsList.size(); i++) {
            Collections.swap(numsList, i, level);
            findPermutations(numsList, resultSet, level + 1);
            Collections.swap(numsList, i, level);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        LC47PermutationsWithDup test = new LC47PermutationsWithDup();
        System.out.println(test.permuteUnique(nums));
    }
}
