package com.techbow.homework.y2021.m09.mengyu;

public class LC_702SearchInUnknownSizeSorted {
    public int search(ArrayReader reader, int target) {
        /*
        t = 13
         0 1 2 3 4  5
        -1 0 3 5 9 12
             l
                 r
         */
        //unknown size, can't determine the right most pointer
        int left = 0;
        int right = 1;
        int mid = 0;
        //find the right boundary first
        while (target > reader.get(right)) {
            left = right;
            right  = 2;
            //don't need to worry about out of bound
            //returns 231 - 1 if the i is out of the boundary of the array.
        }

        //once left and right bound is set, use binary search
        while(left <= right) {
            mid = (right - left) / 2 + left;
            if (reader.get(mid) == target) return mid;
            if(reader.get(mid) < target) {
                left = mid + 1;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}

