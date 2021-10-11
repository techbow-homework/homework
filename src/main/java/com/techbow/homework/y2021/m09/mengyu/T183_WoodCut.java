package com.techbow.homework.y2021.m09.mengyu;

public class T183_WoodCut {
    /*
    Given an int array wood representing the length of n pieces of wood and an int k.
    It is required to cut these pieces of wood such that more or equal to k pieces of the same length len are cut.
    What is the longest len you can get?

Input: wood = [5, 9, 7], k = 3 Output: 5 Explanation: 5 -> 5 9 -> 5 + 4 7 -> 5 + 2

Input: wood = [5, 9, 7], k = 4 Output: 4 Explanation: 5 -> 4 + 1 9 -> 4 * 2 + 1 7 -> 4 + 3
k = 5
5 9 7

     */

    public int woodCut(int[] L, int k) {
        //TODO: corner cases
        if (L == null || L.length == 0 || k <= 0) {
            return 0;
        }
        int shortestWood = 1;
        int longestWood = 0;
        for (int i = 0; i < L.length; i++) {
            longestWood = Math.max(longestWood, L[i]);
        }
        int mid = 0;
        while (shortestWood + 1 < longestWood) {
            mid = (longestWood - shortestWood) / 2 + shortestWood;
            int piecesOfWood = calculatePieces(mid, L);
            if (piecesOfWood < k) {
                longestWood = mid;
            } else {
                shortestWood = mid;
            }
        }
        if (calculatePieces(longestWood, L) >= k) {
            return longestWood;
        } else if (calculatePieces(shortestWood, L) >= k) {
            return shortestWood;
        } else {
            return 0;
        }
    }
    private int calculatePieces(int length, int[] L) {
        int ans = 0;
        for (int woodInL : L) {
            ans = ans + woodInL/length;
        }
        return ans;
    }
}
