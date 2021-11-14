package com.techbow.homework.y2021.m11.mengyu;

import java.util.ArrayList;
import java.util.List;

public class LC77Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneResult = new ArrayList<>();
        dfs(n, k, result, oneResult, 1);
        return result;
    }
    private void dfs (int n, int k, List<List<Integer>> result, List<Integer> oneResult, int start) {
        if (oneResult.size() != k) {
            for (int i = start; i <= n; i++) {
                oneResult.add(i);
                dfs(n, k, result, oneResult, i + 1);
                oneResult.remove(oneResult.size() - 1);
            }
        } else {
            result.add(new ArrayList<>(oneResult));
            return;
        }

    }
}
