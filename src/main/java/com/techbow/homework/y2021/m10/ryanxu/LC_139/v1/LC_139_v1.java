package com.techbow.homework.y2021.m10.ryanxu.LC_139.v1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC_139_v1 {
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null) {
            return false;
        }

        HashSet<String> dictionary = new HashSet<>(wordDict);
        int strLen = s.length();
        Boolean[] memo = new Boolean[strLen];
        return dfs(s, dictionary, 0, memo);
    }

    private boolean dfs(String s, HashSet<String> dictionary, int idx, Boolean[] memo) {

        int strLen = s.length();
        if (idx == strLen) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = idx; i < strLen; i++) {
            String cur = s.substring(idx, i + 1);
            if (dictionary.contains(cur)) {
                if (dfs(s, dictionary, i + 1, memo)) {
                    memo[idx] = true;
                    return true;
                }
            }
        }

        memo[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        LC_139_v1 lc_139 = new LC_139_v1();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(lc_139.wordBreak(s, wordDict));
    }
}
