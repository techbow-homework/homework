/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        return dfs(n, 0, 0, new StringBuilder(), new ArrayList());
        
    }
    private List<String> dfs(int max, int open, int close, StringBuilder curr, List<String> res) {
        if (curr.length() == max*2) {
            res.add(curr.toString());
            return res;
        }
        
        if (open < max) {
            curr.append('(');
            dfs(max, open+1, close, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if (close < open) {
            curr.append(')');
            dfs(max, open, close+1, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }
        
        return res;
    }
}
// @lc code=end

