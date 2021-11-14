package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LC46permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        bfs(numsList, result, 0);
        return result;
    }
    private void bfs(List<Integer> numsList, List<List<Integer>> result, int level) {
        if (level == numsList.size() - 1) {
            result.add(new ArrayList<>(numsList));
            return;
        }
        for (int i = level; i < numsList.size(); i++) {
            Collections.swap(numsList, i, level);
            bfs(numsList, result, level + 1);
            Collections.swap(numsList, i, level);
        }
    }
}
