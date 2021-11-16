package com.techbow.homework.y2021.m11.QiyueWang;

public class LC441ArrangingCoins {
    public static int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        if(n <= 1) return n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(getSum(mid) == n) return mid;
            else if(getSum(mid) > n) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }
    private static long getSum(int row) {
        return (long) (1 + row) * row / 2;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1)); // 1
        System.out.println(arrangeCoins(5)); // 2
        System.out.println(arrangeCoins(1804289383)); // 60070
    }
}
// time O(logN) space O(1)
