package com.techbow.homework.y2021.m10.ryanxu.LC_22;

import java.util.ArrayList;
import java.util.List;

public class LC_22 {
    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(res, path, 0, 0, n);

        return res;
    }

    // left: num of left parentheses already in the path
    // right : num of right parentheses already in the path
    private void dfs(List<String> res, StringBuilder path, int left, int right, int n) {

        if (left == n && right == n) {
            res.add(path.toString());
            return;
        }

        if (right > left || right > n || left > n) {
            return;
        }

        // left
        int lenL = path.length();
        path.append("(");
        dfs(res, path, left + 1, right, n);
        path.setLength(lenL);

        //right
        int lenR = path.length();
        path.append(")");
        dfs(res, path, left, right + 1, n);
        path.setLength(lenR);
    }

    public static void main(String[] args) {
        LC_22 lc_22 = new LC_22();
        System.out.println(lc_22.generateParenthesis(3));
    }
}
