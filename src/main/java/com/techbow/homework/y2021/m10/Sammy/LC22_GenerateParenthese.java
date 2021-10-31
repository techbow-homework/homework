package com.techbow.homework.y2021.m10.Sammy;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthese {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), res, n, 0, 0);
        return res;
    }
    private void dfs(StringBuilder sb, List<String> res, int n, int left, int right){
        if(left + right == 2 * n){
            String temp = sb.toString();
            res.add(temp);
        }

        if(left < n){
            sb.append('(');
            dfs(sb, res, n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            dfs(sb, res, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
