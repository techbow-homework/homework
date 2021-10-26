package com.techbow.homework.y2021.m10.LianjiangHe.BinarySearch;

public class LC374 {
    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is lower than the guess number
     * 1 if num is higher than the guess number
     * otherwise return 0
     * int guess(int num);
     */

//1 <= n <= 2^31 - 1 n belongs to int

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1;
            int r = n;
            while (l <= r) {//l<r行不行?不行,假如l=1=r,明明有答案为1,却返回-1;
                int m = l + (r - l) / 2;
                if (guess(m) == 0) {
                    return m;
                } else if (guess(m) == 1) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return -1;
        }
    }
}