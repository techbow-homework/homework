package com.techbow.homework.y2021.m11.shengyuan;

import java.util.HashMap;
import java.util.Map;

public class LC_91 {
    Map<Integer, Integer> memo = new HashMap<>();
    public int decodeWay(String s) {
        return recursiveWithMemo(0, s);
    }
    public int recursiveWithMemo(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int ans = recursiveWithMemo(index + 1, s);
        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, s);
        }
        memo.put(index, ans);
        return ans;
    }
    public static void main(String[] args) {
        LC_91 test = new LC_91();
        String str = "11106";
        int result = test.decodeWay(str);
        System.out.println(result);
    }
}
