package com.techbow.homework.y2021.m09.boyuan.小宋小宋;

public class LC_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArr = MergeArrays(nums1, nums2);
        int n = mergeArr.length;
        if (n % 2 == 0) {
            return (mergeArr[(n-1)/2] + mergeArr[n/2]) / 2.0;
        } else return mergeArr[n/2];
    }

    private int[] MergeArrays(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < A.length && j < B.length) {
            merged[k++] = (A[i] > B[j]) ? B[j++] :A[i++];
        }
        while (i < A.length) {
            merged[k++] = A[i++];
        }
        while (j < B.length) {
            merged[k++] = B[j++];
        }
        return merged;
    }
}
