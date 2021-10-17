package com.techbow.homework.y2021.m10.ryanxu.LC_294;

import java.util.HashMap;

public class LC_294 {
    public boolean canWin(String s) {

        if (s == null) {
            return false;
        }

        HashMap<String, Boolean> memo = new HashMap<>();
        return dfs(s, memo);
    }

    // idx, idx + 1
    private boolean dfs(String s, HashMap<String, Boolean> memo) {

        Boolean val = memo.get(s);
        if (val != null) {
            return val;
        }

        int strLen = s.length();
        for (int i = 0; i + 1 < strLen; i++) {
            if (s.charAt(i) != '-' && s.charAt(i + 1) != '-') {
                char[] temp = s.toCharArray();
                temp[i] = '-';
                temp[i + 1] = '-';
                if (!dfs(String.valueOf(temp), memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        LC_294 lc_294 = new LC_294();
        String s = "++++";
        System.out.println(lc_294.canWin(s));
    }
}
