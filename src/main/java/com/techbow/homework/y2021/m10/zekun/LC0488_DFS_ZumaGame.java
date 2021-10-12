package com.techbow.homework.y2021.m10.zekun;

import java.util.HashMap;
import java.util.Map;

public class LC0488_DFS_ZumaGame {
    private int min;
    public int findMinStep(String board, String hand) {
        //cc
        if(board == null || hand == null || board.length() == 0 || hand.length() == 0) return -1;
        char[] handChar = hand.toCharArray();
        Map<Character, Integer> handMap = new HashMap<Character, Integer>();
        for(char ch: handChar){
            handMap.put(ch, handMap.getOrDefault(ch, 0) + 1);
        }

        min = board.length() + 1;
        dfsHelper(board, handMap, 0);
        return (min == hand.length() + 1) ? -1 : min;
    }

    private void dfsHelper(String board, Map<Character, Integer> handMap, int numBallsUsed){
        //basecase
        //success
        if(board.length() == 0) {
            if(numBallsUsed < min){
                min = numBallsUsed;
            }
            return;
        }
        //fail
        if(board.length() > 0 && handMap.size() == 0){
            min = -1;
            return;
        };

        //visited?noneed
        //fencha
        for(int i = 0; i < board.length(); i++){
            char curBall = board.charAt(i);
            Integer count = handMap.get(curBall);
            if(count == null) continue;

            //two consequtive balls need one ball
            if(i < board.length() - 1 && curBall == board.charAt(i + 1)){
                int newCount = handMap.remove(curBall) - 1;

                if(newCount > 0) handMap.put(curBall, newCount);
                String newBoard = removeBalls(board, i - 1, i + 2);
                dfsHelper(newBoard, handMap, numBallsUsed + 1);
                handMap.put(curBall, count);//backtracking

            }else if(count >= 2){ //1 balls need two balls;
                handMap.remove(curBall);
                if(count > 2){
                    handMap.put(curBall, count - 2);
                }
                String newBoard = removeBalls(board, i - 1, i + 1);
                dfsHelper(newBoard, handMap, numBallsUsed + 2);
                handMap.put(curBall, count);
            }

        }
    }

    private String removeBalls(String board, int left, int right){
        int len = board.length();
        while(left >= 0 && right < len){
            char c = board.charAt(left);
            int count = 0;

            int l = left;
            while(l >= 0 && board.charAt(l) == c){
                l--;
                count++;

            }

            int r = right;
            while(r < len && board.charAt(r) == c){
                r++;
                count++;
            }

            if(count >= 3){
                left = l;
                right = r;
            }else{
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= left; i++){
            sb.append(board.charAt(i));
        }

        for(int i = right; i < len; i++){
            sb.append(board.charAt(i));

        }
        return sb.toString();
    }
}
