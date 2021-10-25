package com.techbow.homework.y2021.m10.ryanxu.LC_294.v2;

import java.util.HashMap;

public class LC_294_v2 {
    public boolean canWin(String s) {

        if (s == null) {
            return false;
        }

        long board = getBoard(s);
        int boardLen = s.length();
        HashMap<Long, Boolean> memo = new HashMap<>();
        return dfs(board, boardLen, memo);
    }

    private boolean dfs(long board, int boardLen, HashMap<Long, Boolean> memo) {

        Boolean val = memo.get(board);
        if (val != null) {
            return val;
        }

        for (int i = 0; i + 1 < boardLen; i++) {
            if ((board & (1 << i)) == 0 && (board & (1 << (i + 1))) == 0) {
                long newBoard = board | (1 << i);
                newBoard |= (1 << (i + 1));
                if (!dfs(newBoard, boardLen, memo)) {
                    memo.put(board, true);
                    return true;
                }
            }
        }

        memo.put(board, false);
        return false;
    }

    // 1:'-'  0:'+'
    private long getBoard(String s) {

        int strLen = s.length();
        long board = 0;
        for (int i = 0; i < strLen; i++) {
            if (s.charAt(i) == '-') {
                board ^= (1 << (i));
            }
        }

        return board;
    }

    public static void main(String[] args) {
        String s = "++++";
        LC_294_v2 lc_294_v2 = new LC_294_v2();
        System.out.println(lc_294_v2.canWin(s));
    }
}
