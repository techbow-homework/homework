package com.techbow.homework.y2021.m10.ryanxu.LC_403;

import java.util.HashMap;

public class LC_403 {

    public boolean canCross(int[] stones) {

        if (stones == null) {
            return false;
        }

        int inputLen = stones.length;
        HashMap<Integer, Boolean>[] memo = new HashMap[inputLen];
        for (int i = 0; i < inputLen; i++) {
            memo[i] = new HashMap<>();
        }

        return dfs(stones, 0, 1, memo);
    }

    // idx: the stone which the frog stand on
    private boolean dfs(int[] stones, int idx, int lastStep, HashMap<Integer, Boolean>[] memo) {

        int inputLen = stones.length;
        if (idx == inputLen - 1) {
            return true;
        }

        Boolean val = memo[idx].get(lastStep);
        if (val != null) {
            return val;
        }

        // i: represent next stone
        for (int i = idx + 1; i < inputLen; i++) {
            // lastStep - 1
            int nextStep = stones[idx] + lastStep - 1;
            if (idx != 0 && stones[i] - nextStep == 0) {
                if (dfs(stones, i, stones[i] - stones[idx], memo)) {
                    memo[idx].put(lastStep, true);
                    return true;
                }
            }
            // lastStep
            nextStep = stones[idx] + lastStep;
            if (stones[i] - nextStep == 0) {
                if (dfs(stones, i, stones[i] - stones[idx], memo)) {
                    memo[idx].put(lastStep, true);
                    return true;
                }
            }
            // lastStep + 1
            nextStep = stones[idx] + lastStep + 1;
            if (idx != 0 && stones[i] - nextStep == 0) {
                if (dfs(stones, i, stones[i] - stones[idx], memo)) {
                    memo[idx].put(lastStep, true);
                    return true;
                }
            }
        }

        memo[idx].put(lastStep, false);
        return false;
    }

    public static void main(String[] args) {
        LC_403 lc_403 = new LC_403();
        int[] stones = {0,1,2,5,6,9,10,12,13,14,17,19,20,21,26,27,28,29,30};
        System.out.println(lc_403.canCross(stones));
    }
}
