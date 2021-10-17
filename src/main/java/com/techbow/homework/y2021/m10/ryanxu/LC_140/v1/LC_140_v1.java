package com.techbow.homework.y2021.m10.ryanxu.LC_140.v1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC_140_v1 {
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();
        if (s == null || wordDict == null) {
            return res;
        }

        HashSet<String> wordSet = new HashSet<>(wordDict);
        StringBuilder path = new StringBuilder();
        dfs(s, wordSet, res, path, 0);
        return res;
    }

    private void dfs(String s, HashSet<String> wordSet, List<String> res, StringBuilder path, int idx) {

        int sLen = s.length();
        int pathLen = path.length();

        if (idx == sLen) {
            path.setLength(pathLen - 1);
            res.add(path.toString());
            return;
        }

        for (int i = idx; i < sLen; i++) {
            String curWord = s.substring(idx, i + 1);
            if (wordSet.contains(curWord)) {
                path.append(curWord).append(" ");
                dfs(s, wordSet, res, path, i + 1);
                path.setLength(pathLen);
            }
        }
    }

    }
