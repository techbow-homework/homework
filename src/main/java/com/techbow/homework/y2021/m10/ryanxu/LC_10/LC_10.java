package com.techbow.homework.y2021.m10.ryanxu.LC_10;

public class LC_10 {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        Boolean[][] memo = new Boolean[sLen + 1][pLen + 1];
        return dfs(s, p, 0, 0, memo);
    }

    private boolean dfs(String s, String p, int sIdx, int pIdx, Boolean[][] memo) {

        int sLen = s.length();
        int pLen = p.length();
        if (pIdx == pLen) {
            return sIdx == sLen;
        }

        if (memo[sIdx][pIdx] != null) {
            return memo[sIdx][pIdx];
        }

        // 非 a*
        if (pIdx == pLen - 1 || p.charAt(pIdx + 1) != '*') {
            if (sIdx < sLen && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.')) {
                if (dfs(s, p, sIdx + 1, pIdx + 1, memo)) {
                    memo[sIdx][pIdx] = true;
                    return true;
                }
            } else {
                memo[sIdx][pIdx] = false;
                return false;
            }
        } else { // a*
            int i = sIdx - 1;
            while (i == sIdx - 1 || (i < sLen && (s.charAt(i) == p.charAt(pIdx) || p.charAt(pIdx) == '.'))) {
                if (dfs(s, p, i + 1, pIdx + 2, memo)) {
                    memo[sIdx][pIdx] = true;
                    return true;
                }
                i++;
            }
        }

        memo[sIdx][pIdx] = false;
        return false;
    }

    public static void main(String[] args) {
        LC_10 lc_10 = new LC_10();
        String s = "ab";
        String p = ".*c";
        System.out.println(lc_10.isMatch(s, p));
    }
}
