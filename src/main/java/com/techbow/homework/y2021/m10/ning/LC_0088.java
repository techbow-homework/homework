package com.techbow.homework.y2021.m10.ning;

/*
constraints:
nums1.length == m+n
nums2.length == n
0 <= m,n <= 200
1 <= m+n <= 200
 */

public class LC_0088 {
    // S1: brute force -- merge and sort time: O((m+n) * log(m+n)) space: O(n)
    // S2: 3 pointers from beginning
    // time: O(m+n)
    // space: O(m)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        int p1 = 0;
        int p2 = 0;
        for (int p = 0; p < m + n; p++) {
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
    }

    // S3: 3 pointers from the end
    // time: O(m+n)
    // space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) break;
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}
