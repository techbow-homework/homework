package com.techbow.homework.y2021.m09.mengyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //TODO: corner case
        /*
        x = 3.5
        1 2 3 4 5 6
                l
                  r
                m
        */
        int left = 0, right = arr.length - 1;
        int mid = 0;
        List<Integer> res = new ArrayList();
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        boolean leftFlag = false;
        boolean rightFlag = false;
        while (k > 0) {
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) && leftFlag == false) {
                res.add(arr[left]);
                if (left == 0) {
                    leftFlag = true;
                    k--;
                } else {
                    left--;
                    k--;
                }
            } else if(Math.abs(arr[right] - x) < Math.abs(arr[left] - x) && rightFlag == false){
                res.add(arr[right]);
                if (right == arr.length - 1) {
                    rightFlag = true;
                    k--;
                } else {
                    right++;
                    k--;
                }
            } else if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x) && rightFlag == true){
                res.add(arr[left]);
                left--;
                k--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) && leftFlag == true) {
                res.add(arr[right]);
                right++;
                k--;
            }
        }
        res.sort(Comparator.naturalOrder());
        return res;
    }
}
