package com.techbow.homework.y2021.m10.ryanxu.LC_320;

import java.util.ArrayList;
import java.util.List;

public class LC_320 {

    public List<String> generateAbbreviations(String word) {

        if (word == null || word.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, word, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, String word, int idx, int count) {

        int len = word.length();
        int pathLen = path.length();

        if (idx == len) {
            if (count > 0) {
                path.append(count);
            }
            res.add(path.toString());
            path.setLength(pathLen);
            return;
        }

        // digit
        dfs(res, path, word, idx + 1, count + 1);

        // keep
        if (count > 0) {
            path.append(count);
        }
        path.append(word.charAt(idx));
        dfs(res, path, word, idx + 1, 0);
        path.setLength(pathLen);
    }
}
