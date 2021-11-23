package com.techbow.homework.y2021.m11.mengyu;

import java.util.HashMap;
import java.util.Map;

public class LC91 {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return recursiveWithMemo(0, s, memo);
    }

    private int recursiveWithMemo(int index, String str, Map<Integer, Integer> memo) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }


        int ans = recursiveWithMemo(index + 1, str, memo);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str, memo);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }

    public static void main(String[] args) {
        LC91 test = new LC91();
        System.out.println(test.numDecodings("102014"));
    }
}
