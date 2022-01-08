package com.techbow.homework.y2021.m10.ryanxu.LC_1217;

public class LC_1217 {
    public int minCostToMoveChips(int[] position) {

        if (position == null || position.length == 0) {
            return 0;
        }

        int evenCount = 0;
        int oddCount = 0;
        for (int num : position) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(evenCount, oddCount);
    }
}
