package com.techbow.homework.y2021.m10.ryanxu.LC_464;

import java.util.HashMap;

public class LC_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal < 0) {
            return false;
        }

        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        HashMap<Integer, Boolean> memo = new HashMap<>();

        return dfs(0, 0, desiredTotal, maxChoosableInteger, memo);
    }

    private boolean dfs(int board, int sum, int desiredTotal, int maxChoosableInteger, HashMap<Integer, Boolean> memo) {

        if (sum >= desiredTotal) {
            return false;
        }

        Boolean val = memo.get(board);
        if (val != null) {
            return val;
        }

        for (int i = 0; i < maxChoosableInteger; i++) {
            if (isValid(board, i)) {
                if (sum + i + 1 >= desiredTotal) {
                    memo.put(board, true);
                    return true;
                }
                int newBoard = board | (1 << i);
                if (!dfs(newBoard, sum + i + 1, desiredTotal, maxChoosableInteger, memo)) {
                    memo.put(board, true);
                    return true;
                }
            }
        }

        memo.put(board, false);
        return false;
    }

    // 0: available  1: used
    private boolean isValid(int board, int idx) {

        if ((board & (1 << idx)) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        LC_464 lc_464 = new LC_464();
        int maxChoosableInteger = 7;
        int desiredTotal = 16;
        System.out.println(lc_464.canIWin(maxChoosableInteger, desiredTotal));
        System.out.println(5 & 4);
    }
}
