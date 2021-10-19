package com.techbow.homework.y2021.m10.qiangzhai;

public class LC22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    private void dfs(int n, int l, int r, StringBuilder sb, List<String> res) {
        //base case
        if (l + r == 2 * n) {
            res.add(sb.toString());
            return;
        }
        //
        if (l < n) {
            sb.append("(");
            dfs(n, l + 1, r, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            dfs(n, l, r + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
