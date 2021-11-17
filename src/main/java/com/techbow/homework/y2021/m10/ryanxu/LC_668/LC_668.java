package com.techbow.homework.y2021.m10.ryanxu.LC_668;

public class LC_668 {
    public int findKthNumber(int m, int n, int k) {

        int start = 1;
        int end = m * n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = countLessAndEqual(mid, m, n);
            if (val < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    private int countLessAndEqual(int val, int m, int n) {

        int res = 0;
        for (int i = 1; i <= m; i++) {
            res += Math.min(val / i, n);
        }

        return res;
    }

    public static void main(String[] args) {
        LC_668 lc_668 = new LC_668();
        int m = 12;
        int n = 45;
        int k = 471;
        System.out.println(lc_668.findKthNumber(m, n, k));
    }
}
