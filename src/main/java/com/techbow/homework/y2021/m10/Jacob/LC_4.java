package com.techbow.homework.y2021.m10.Jacob;

public class LC_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return 0.0;
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int k = (n1 + n2 + 1) / 2;

        int l = 0, r = n1;
        while (l < r) {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2-1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        int m1 = l;
        int m2 = k - m1;

        double ckminus1 = Math.max(m1 < 1 ? Integer.MIN_VALUE : nums1[m1-1],
                m2 < 1 ? Integer.MIN_VALUE : nums2[m2-1]);
        if (((n1 + n2) & 1) == 1) return ckminus1;

        double ck = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (ckminus1 + ck) * 0.5;
    }
}
