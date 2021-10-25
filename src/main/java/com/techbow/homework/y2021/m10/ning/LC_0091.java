package com.techbow.homework.y2021.m10.ning;

/*
constraints:
1 <= s.length <= 100
s may contain leading zero
 */
public class LC_0091 {
    // S1: recursive with memo
    /* thought process: the key point for this question is, we could either decode using single digit or
    double digits, so our recursion tree would be whether using single digit or double digits for this level.
    ie. 326 --> branch A: 3_26 branch B: 32_6
    */
    // time: O(n)
    // space: O(n)
    // save previous answers already seen, Map<current index, number of ways>
//    Map<Integer, Integer> memo = new HashMap<>();
//    public int numDecoding(String s) {
//        return recursiveWithMemo(0, s);
//    }
//    private int recursiveWithMemo(int index, String str) {
//        if (memo.containsKey(index)) {
//            return memo.get(index);
//        }
//        // hit the end, no more solutions
//        if (index == str.length()) {
//            return 1;
//        }
//        // index as 0 means no solution
//        if (str.charAt(index) == '0') {
//            return 0;
//        }
//        // reach the last value of the array, and its not 0 means there is one way
//        if (index == str.length() - 1) {
//            return 1;
//        }
//        // using single digit to decode
//        int res = recursiveWithMemo(index + 1, str);
//        // using double digits to decode
//        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
//            res += recursiveWithMemo(index + 2, str);
//        }
//        memo.put(index, res);
//        return res;
//    }

    // S2: dp[]
    // time: O(n)
    // space: O(n) --> to optimize, only use two variables
//    public int numDecodings(String s) {
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        int n = s.length();
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 1; i < n; i++) {
//            if (s.charAt(i) != '0') {
//                dp[i + 1] += dp[i];
//            }
//
//            int twoDigit = Integer.parseInt(s.subtring(i - 1, i + 1));
//            if (twoDigit >= 10 && twoDigit <= 26) {
//                dp[i + 1] += dp[i - 1];
//            }
//        }
//        return dp[n];
//    }

    // S3: dp with two variables
    // time: O(n)
    // space: O(1)
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < n; i++) {
            int cur = 0;
            if (s.charAt(i) != '0') {
                cur += oneBack;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                cur += twoBack;
            }
            twoBack = oneBack;
            oneBack = cur;
        }
        return oneBack;
    }
}
