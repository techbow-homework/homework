package com.techbow.homework.y2021.m10.ryanxu.LC_488;

import java.util.HashMap;

public class LC_488 {
    public int findMinStep(String board, String hand) {

        if (board == null || hand == null) {
            return -1;
        }

        HashMap<Character, Integer> handMap = new HashMap<>();
        int handLen = hand.length();
        for (int i = 0; i < handLen; i++) {
            char cur = hand.charAt(i);
            Integer val = handMap.getOrDefault(cur, 0);
            handMap.put(cur, val + 1);
        }

        return dfs(board, handMap);
    }

    // To clear the board, the min num of balls are needed
    private int dfs(String board, HashMap<Character, Integer> handMap) {

        if (board.length() == 0) {
            return 0;
        }

        if (handMap.size() == 0) {
            return -1;
        }

        int boardLen = board.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < boardLen; i++) {
            char cur = board.charAt(i);
            // need one ball
            Integer curNum = handMap.get(cur);
            if (curNum == null) {
                continue;
            }
            if (i + 1 < boardLen && board.charAt(i + 1) == cur) {
                handMap.remove(cur);
                if (curNum - 1 > 0) {
                    handMap.put(cur, curNum - 1);
                }
                String newBoard = getNewBoard(board, i - 1, i + 2); // TODO
                int val = dfs(newBoard, handMap);
                min = val == -1 ? Integer.MAX_VALUE : Math.min(val + 1, min);
                handMap.put(cur, curNum);
            } else if (curNum >= 2) { // need two balls
                handMap.remove(cur);
                if (curNum - 2 > 0) {
                    handMap.put(cur, curNum - 2);
                }
                String newBoard = getNewBoard(board, i - 1, i + 1);
                int val = dfs(newBoard, handMap);
                min = val == -1 ? Integer.MAX_VALUE : Math.min(val + 2, min);
                handMap.put(cur, curNum);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private String getNewBoard(String board, int l, int r) {

        int count = 1;
        int left = l;
        int right = r;
        int boardLen = board.length();
        while (left >= 0 && r < boardLen) {
            char cur = board.charAt(left);
            int i = left;
            while (left - 1 >= 0 && board.charAt(left - 1) == cur) {
                count++;
                left--;
            }
            int j = right;
            while (right + 1 < boardLen && board.charAt(right + 1) == cur) {
                count++;
                right++;
            }
            if (count < 3) {
                break;
            } else {
                left = i;
                right = j;
            }
        }

        return board.substring(0, left + 1) + board.substring(right, boardLen);
    }
}
