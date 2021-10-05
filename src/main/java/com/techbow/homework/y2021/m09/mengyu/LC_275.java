package com.techbow.homework.y2021.m09.mengyu;

public class LC_275 {
    public int hIndex(int[] citations) {
        //h out of n papers have h citation
        //n - h papers have no more than h citations
        //we have length of citations
        /*
        if (citations == null || citations.length == 0) return -1;
        if (citations.length == 1 && citations[0] == 0) return 0;
        if (citations.length == 1) return 1;
        */
        //TODO: corner cases

        int left = 0;
        int right = citations.length - 1;
        int mid = 0;
        int length = citations.length;

        while (left <= right) {
            mid = left + (right - left) / 2;
            //int length = citations.length;
            //length shouldn't be changing
            if (citations[mid] == length - mid) {
                return citations[mid];
            } else if (citations[mid] < length - mid) {
                left = mid + 1;
            } else if (citations[mid] > length - mid) {
                right = mid - 1;
            }

        }
        return length - left;
    }
}
