package com.techbow.homework.y2021.m10.ryanxu.LC_902;

public class LC_902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        if (digits == null || digits.length == 0) {
            return 0;
        }

        String num = String.valueOf(n);
        int digitsLen = digits.length;
        int numLen = num.length();
        int[] board = new int[digitsLen];
        for (int i = 0; i < digitsLen; i++) {
            board[i] = Integer.valueOf(digits[i]);
        }
        // digit < numLen
        int res = 0;
        for (int i = 0; i < numLen - 1; i++) {
            res += Math.pow(digitsLen, i + 1);
        }

        int[] count = new int[1];
        // 长度等于n
        dfs(0, 0, board, num, count);
        return res + count[0];
    }

    // 长度等于n
    private void dfs(long curNum, int idx, int[] board, String target, int[] count) {

        int len = target.length();
        if (curNum > Integer.parseInt(target)) {
            return;
        }
        if (idx == len && curNum == Integer.parseInt(target)) {
            count[0]++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i] < target.charAt(idx) - '0') {
                count[0] += Math.pow(board.length, len - idx - 1);
            } else if (board[i] == target.charAt(idx) - '0') {
                curNum = curNum * 10 + board[i];
                dfs(curNum, idx + 1, board, target, count);
            }
        }
    }

    public static void main(String[] args) {
        LC_902 lc_902 = new LC_902();
        String[] digits = {"1","2","3","4","6","7","9"};
        int n = 333;
        System.out.println(lc_902.atMostNGivenDigitSet(digits, n));
    }
}
