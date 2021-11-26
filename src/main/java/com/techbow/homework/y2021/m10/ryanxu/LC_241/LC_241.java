package com.techbow.homework.y2021.m10.ryanxu.LC_241;

import java.util.ArrayList;
import java.util.List;

public class LC_241 {
    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> res = new ArrayList<>();
        if (expression == null || expression.length() == 0) {
            return res;
        }

        res = dfs( expression, 0, expression.length() - 1);
        return res;
    }

    private List<Integer> dfs(String expression, int start, int end) {

        List<Integer> res = new ArrayList<>();
        if (start > end) {
            return res;
        }

        boolean isNum = true;
        for (int i = start; i <= end; i++) {
            char cur = expression.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                isNum = false;
                List<Integer> left = dfs(expression, start, i - 1);
                List<Integer> right = dfs(expression, i + 1, end);
                for (Integer l : left) {
                    for (Integer r : right) {
                        res.add(calculate(l, r, cur));
                    }
                }
            }
        }

        if (isNum) {
            res.add(Integer.valueOf(expression.substring(start, end + 1)));
        }

        return res;
    }

    private Integer calculate(Integer l, Integer r, char cur) {

        Integer res = 0;
        if (cur == '+') {
            res = l + r;
        } else if (cur == '-') {
            res = l - r;
        } else {
            res = l * r;
        }

        return res;
    }

    public static void main(String[] args) {
        LC_241 lc_241 = new LC_241();
        String expression = "2-1-1";
        System.out.println(lc_241.diffWaysToCompute(expression));
    }
}
