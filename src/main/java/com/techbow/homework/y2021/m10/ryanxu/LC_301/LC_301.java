package com.techbow.homework.y2021.m10.ryanxu.LC_301;

import java.util.ArrayList;
import java.util.List;

public class LC_301 {
    public List<String> removeInvalidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        // find out how many left and right parentheses need to be removed
        int[] rmlAndRmr = minRemoveNum(s);
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, s, 0, rmlAndRmr[0], rmlAndRmr[1], 0);
        return res;
    }

    // l -> num of '(' need to be removed
    // r -> num of ')' need to be removed
    // delta -> In the path, num of '(' - num of ')'
    private void dfs(List<String> res, StringBuilder path, String s, int idx, int l, int r, int delta) {

        int len = s.length();
        if (idx == len && l == 0 && r == 0 && delta == 0) {
            res.add(path.toString());
            return;
        }

        if (idx >= len || l < 0 || r < 0 || delta < 0) {
            return;
        }

        // one direction scan -> no visit
        char cur = s.charAt(idx);
        int pathLen = path.length();
        if (cur == '(') {
            // keep
            path.append('(');
            dfs(res, path, s, idx + 1, l, r, delta + 1);
            path.setLength(pathLen);

            // remove
            int count = 1;
            while (idx + count < len && s.charAt(idx + count) == '(') {
                count++;
            }
            dfs(res, path, s, idx + count, l - count, r, delta);
        } else if (cur == ')') {
            // keep
            path.append(')');
            dfs(res, path, s, idx + 1, l, r, delta - 1);
            path.setLength(pathLen);

            // remove
            int count = 1;
            while (idx + count < len && s.charAt(idx + count) == ')') {
                count++;
            }
            dfs(res, path, s, idx + count, l, r - count, delta);
        } else {
            path.append(cur);
            dfs(res, path, s, idx + 1, l, r, delta);
            path.setLength(pathLen);
        }
    }

    private int[] minRemoveNum(String s) {
        int rml = 0;
        int rmr = 0;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                rml++;
            } else if (cur == ')') {
                if (rml > 0) {
                    rml--;
                } else {
                    rmr++;
                }
            }
        }

        return new int[] {rml, rmr};
    }

}
