package com.techbow.homework.y2021.m10.ryanxu.LC_132;

public class LC_132 {

    public int minCut(String s) {

        if (s == null) {
            return 0;
        }

        int strLen = s.length();
        Integer[] memo = new Integer[strLen + 1];
        boolean[][] isPA = new boolean[strLen + 1][strLen + 1];
        return dfs(s, 0, memo, isPA) - 1;
    }

    // the minimum num of palindrome  s[idx, strLen)
    // cut or not
    // [idx, i] [i + 1, strLen)
    private int dfs(String s, int idx, Integer[] memo, boolean[][] isPa) {

        if (memo[idx] != null) {
            return memo[idx];
        }

        int strLen = s.length();
        if (idx == strLen) {
            return 0;
        }

        int minNumOfPalindrome = Integer.MAX_VALUE;
        for (int i = idx; i < strLen; i++) {
            // cut
            if (idx == i || (idx + 1 == i && s.charAt(idx) == s.charAt(i))
                    || (s.charAt(idx) == s.charAt(i)) && isPa[idx + 1][i - 1]) { //
                isPa[idx][i] = true;
                minNumOfPalindrome = Math.min(minNumOfPalindrome, dfs(s, i + 1, memo, isPa) + 1);
            }
            // not
        }

        memo[idx] = minNumOfPalindrome == Integer.MAX_VALUE ? 1 : minNumOfPalindrome;
        return memo[idx];
    }

    // [)
    private boolean isPalindrome(String s, int i, int j) {

        if (i == j) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            if (i + 1 == j) {
                return true;
            }
            return isPalindrome(s, i + 1, j - 1);
        }

        return false;
    }

    public static void main(String[] args) {
        LC_132 lc_132 = new LC_132();
        String s = "hhj";
        System.out.println(lc_132.minCut(s));
    }
}
